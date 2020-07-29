package co.jast.monolito.booking.interfaces.rest.transform;

import co.jast.monolito.booking.domain.commands.RouteCargoCommand;
import co.jast.monolito.booking.interfaces.rest.dto.RouteCargoResource;

public class RouteCargoCommandDTOAssembler {

    /**
     * Static method within the Assembler class
     *
     * @param routeCargoResource
     * @return RouteCargoCommand Model
     */
    public static RouteCargoCommand toCommandFromDTO(RouteCargoResource routeCargoResource) {

        return new RouteCargoCommand(routeCargoResource.getBookingId());
    }
}
