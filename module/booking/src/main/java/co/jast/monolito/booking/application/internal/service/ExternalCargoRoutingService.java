package co.jast.monolito.booking.application.internal.service;

import co.jast.monolito.booking.domain.entities.Location;
import co.jast.monolito.booking.domain.valueobjects.CargoItinerary;
import co.jast.monolito.booking.domain.valueobjects.Leg;
import co.jast.monolito.booking.domain.valueobjects.RouteSpecification;
import co.jast.monolito.booking.domain.valueobjects.Voyage;
import co.jast.monolito.booking.infrastructure.http.ExternalCargoRoutingClient;
import co.jast.monolito.shared.model.TransitEdge;
import co.jast.monolito.shared.model.TransitPath;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Anti Corruption Service Class
 */
@ApplicationScoped
public class ExternalCargoRoutingService {

    @Inject
    private ExternalCargoRoutingClient externalCargoRoutingClient;

    /**
     * The Booking Bounded Context makes an external call to the Routing Service of the Routing Bounded Context to
     * fetch the Optimal Itinerary for a Cargo based on the Route Specification
     * @param routeSpecification
     * @return
     */
    public CargoItinerary fetchRouteForSpecification(RouteSpecification routeSpecification){

        TransitPath transitPath = externalCargoRoutingClient.findOptimalRoute(
                routeSpecification.getOrigin().getUnLocCode(),
                routeSpecification.getDestination().getUnLocCode(),
                routeSpecification.getArrivalDeadline().toString()
        );

        List<Leg> legs = new ArrayList<Leg>(transitPath.getTransitEdges().size());
        for (TransitEdge edge : transitPath.getTransitEdges()) {
            legs.add(toLeg(edge));
        }

        return new CargoItinerary(legs);

    }

    /**
     * Anti-corruption layer conversion method from the routing service's domain model (TransitEdges)
     * to the domain model recognized by the Booking Bounded Context (Legs)
     * @param edge
     * @return
     */
    private Leg toLeg(TransitEdge edge) {
        return new Leg(
                new Voyage(edge.getVoyageNumber()),
                new Location(edge.getFromUnLocode()),
                new Location(edge.getToUnLocode()),
                edge.getFromDate(),
                edge.getToDate());
    }
}
