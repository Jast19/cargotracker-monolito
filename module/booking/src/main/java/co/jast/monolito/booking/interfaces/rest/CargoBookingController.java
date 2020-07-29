package co.jast.monolito.booking.interfaces.rest;

import co.jast.monolito.booking.application.internal.commandservices.CargoBookingCommandService;
import co.jast.monolito.booking.application.internal.commandservices.ExampleCDI;
import co.jast.monolito.booking.domain.aggregates.BookingId;
import co.jast.monolito.booking.interfaces.rest.dto.BookCargoResource;
import co.jast.monolito.booking.interfaces.rest.transform.BookCargoCommandDTOAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cargobooking")
@ApplicationScoped
public class CargoBookingController {

    @Inject
    private CargoBookingCommandService cargoBookingCommandService; // Application Service Dependency

    @Inject
    private ExampleCDI exampleCDI;

    /**
     * POST method to book a cargo
     *
     * @param bookCargoResource
     */

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookCargo(BookCargoResource bookCargoResource) {
        System.out.println("****Book Cargo" + cargoBookingCommandService);
        BookingId bookingId = cargoBookingCommandService.bookCargo(
                BookCargoCommandDTOAssembler.toCommandFromDTO(bookCargoResource));

        final Response returnValue = Response.ok()
                .entity(bookingId)
                .build();
        return returnValue;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        final Response returnValue = Response.ok()
                .entity(this.exampleCDI.value())
                .build();
        return returnValue;
    }
}
