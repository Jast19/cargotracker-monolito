package co.jast.monolito.handling.application.commandservices;


import co.jast.monolito.handling.domain.aggregates.HandlingActivity;
import co.jast.monolito.handling.domain.commands.HandlingActivityRegistrationCommand;
import co.jast.monolito.handling.domain.valueobjects.CargoBookingId;
import co.jast.monolito.handling.domain.valueobjects.Location;
import co.jast.monolito.handling.domain.valueobjects.Type;
import co.jast.monolito.handling.domain.valueobjects.VoyageNumber;
import co.jast.monolito.handling.infrastructure.repository.HandlingActivityRepository;
import co.jast.monolito.shared.events.CargoHandledEvent;
import co.jast.monolito.shared.events.CargoHandledEventData;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class HandlingActivityRegistrationCommandService {

    @Inject
    private HandlingActivityRepository handlingActivityRepository;

    @Inject
    private Event<CargoHandledEvent> cargoHandledEventControl; // Event that needs to be raised when the Cargo is Handled


    /**
     * Service Command method to register a new Handling Activity
     *
     * @return BookingId of the CargoBookingId
     */
    @Transactional
    public void registerHandlingActivityService(HandlingActivityRegistrationCommand handlingActivityRegistrationCommand) {
        System.out.println("Handling Voyage Number is" + handlingActivityRegistrationCommand.getVoyageNumber());
        if (!handlingActivityRegistrationCommand.getVoyageNumber().equals("")) {
            HandlingActivity handlingActivity = new HandlingActivity(
                    new CargoBookingId(handlingActivityRegistrationCommand.getBookingId()),
                    handlingActivityRegistrationCommand.getCompletionTime(),
                    Type.valueOf(handlingActivityRegistrationCommand.getHandlingType()),
                    new Location(handlingActivityRegistrationCommand.getUnLocode()),
                    new VoyageNumber(handlingActivityRegistrationCommand.getVoyageNumber()));
            handlingActivityRepository.store(handlingActivity);


        } else {
            HandlingActivity handlingActivity = new HandlingActivity(
                    new CargoBookingId(handlingActivityRegistrationCommand.getBookingId()),
                    handlingActivityRegistrationCommand.getCompletionTime(),
                    Type.valueOf(handlingActivityRegistrationCommand.getHandlingType()),
                    new Location(handlingActivityRegistrationCommand.getUnLocode()));
            handlingActivityRepository.store(handlingActivity);
        }


        CargoHandledEvent cargoHandledEvent = new CargoHandledEvent();
        CargoHandledEventData eventData = new CargoHandledEventData();
        eventData.setBookingId(handlingActivityRegistrationCommand.getBookingId());
        eventData.setHandlingCompletionTime(handlingActivityRegistrationCommand.getCompletionTime());
        eventData.setHandlingLocation(handlingActivityRegistrationCommand.getUnLocode());
        eventData.setHandlingType(handlingActivityRegistrationCommand.getHandlingType());
        eventData.setVoyageNumber(handlingActivityRegistrationCommand.getVoyageNumber());

        System.out.println("***Event Data ***" + eventData);
        cargoHandledEvent.setContent(eventData);

        System.out.println("*****cargohandlede" + handlingActivityRegistrationCommand.getBookingId() + " " + handlingActivityRegistrationCommand.getHandlingType()
                + " " + handlingActivityRegistrationCommand.getCompletionTime() + " " + handlingActivityRegistrationCommand.getUnLocode());

        cargoHandledEventControl.fire(cargoHandledEvent);

    }
}
