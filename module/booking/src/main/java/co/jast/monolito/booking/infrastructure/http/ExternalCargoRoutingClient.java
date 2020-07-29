package co.jast.monolito.booking.infrastructure.http;

import co.jast.monolito.shared.model.TransitPath;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class ExternalCargoRoutingClient {

    public TransitPath findOptimalRoute(String origin, String destination, String arrivalDeadline){
        final String REST_URI
                = "http://localhost:9080/cargotracker/serviceapi/voyageRouting/optimalRoute";

        Client client = ClientBuilder.newClient();

        return client
                .target(REST_URI)
                .queryParam("origin",origin)
                .queryParam("destination",destination)
                .queryParam("deadline",arrivalDeadline)
                .request(MediaType.APPLICATION_JSON)
                .get(TransitPath.class);

    }
}
