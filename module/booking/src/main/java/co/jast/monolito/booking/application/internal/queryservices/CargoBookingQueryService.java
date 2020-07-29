package co.jast.monolito.booking.application.internal.queryservices;

import co.jast.monolito.booking.domain.aggregates.BookingId;
import co.jast.monolito.booking.domain.aggregates.Cargo;
import co.jast.monolito.booking.infrastructure.repository.CargoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CargoBookingQueryService {

    @Inject
    private CargoRepository cargoRepository; // Inject Dependencies

    /**
     * Find all Cargos
     * @return List<Cargo>
     */
    @Transactional
    public List<Cargo> findAll(){
        return cargoRepository.findAll();
    }

    /**
     * List All Booking Identifiers
     * @return List<BookingId>
     */
    public List<BookingId> getAllBookingIds(){
        return cargoRepository.findAllBookingIds();
    }

    /**
     * Find a specific Cargo based on its Booking Id
     * @param bookingId
     * @return Cargo
     */
    public Cargo find(String bookingId){
        return cargoRepository.find(new BookingId(bookingId));
    }
}
