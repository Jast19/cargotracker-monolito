package co.jast.monolito.booking.application.internal.commandservices;

import co.jast.monolito.booking.application.internal.service.ExternalCargoRoutingService;
import co.jast.monolito.booking.domain.aggregates.BookingId;
import co.jast.monolito.booking.domain.aggregates.Cargo;
import co.jast.monolito.booking.domain.commands.BookCargoCommand;
import co.jast.monolito.booking.domain.commands.RouteCargoCommand;
import co.jast.monolito.booking.domain.valueobjects.CargoItinerary;
import co.jast.monolito.booking.infrastructure.repository.CargoRepository;
import co.jast.monolito.shared.events.CargoBookedEvent;
import co.jast.monolito.shared.events.CargoRoutedEvent;
import co.jast.monolito.shared.events.CargoRoutedEventData;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class CargoBookingCommandService {
    @Inject
    private CargoRepository cargoRepository; // Outbound Service to connect to the Booking Bounded Context MySQL Database Instance

    @Inject
    private Event<CargoBookedEvent> cargoBookedEventControl;

    @Inject
    private Event<CargoRoutedEvent> cargoRoutedEventControl; // Event that needs to be raised when the Cargo is Booked

    @Inject
    private ExternalCargoRoutingService externalCargoRoutingService;

    /**
     * Service Command method to book a new Cargo
     *
     * @return BookingId of the Cargo
     */
    @Transactional // Inititate the Transaction
    public BookingId bookCargo(BookCargoCommand bookCargoCommand) {
        String bookingId = cargoRepository.nextBookingId();
        bookCargoCommand.setBookingId(bookingId);
        Cargo cargo = new Cargo(bookCargoCommand);
        cargoRepository.store(cargo); //Store the Cargo

        CargoBookedEvent cargoBookedEvent = new CargoBookedEvent();
        cargoBookedEvent.setId(bookingId); //Set the content of the event
        cargoBookedEventControl.fire(cargoBookedEvent);

        return new BookingId(bookingId);
    }

    /**
     * Service Command method to assign a route to a Cargo
     *
     * @param routeCargoCommand
     */
    @Transactional
    public void assignRouteToCargo(RouteCargoCommand routeCargoCommand) {
        Cargo cargo = cargoRepository.find(new BookingId(routeCargoCommand.getCargoBookingId()));

        CargoItinerary cargoItinerary = externalCargoRoutingService
                .fetchRouteForSpecification(cargo.getRouteSpecification());

        cargo.assignToRoute(cargoItinerary);
        cargoRepository.store(cargo);

        CargoRoutedEvent cargoRoutedEvent = new CargoRoutedEvent();
        CargoRoutedEventData eventData = new CargoRoutedEventData();
        eventData.setBookingId(routeCargoCommand.getCargoBookingId());
        cargoRoutedEvent.setContent(eventData);
        cargoRoutedEventControl.fire(cargoRoutedEvent);
    }
}
