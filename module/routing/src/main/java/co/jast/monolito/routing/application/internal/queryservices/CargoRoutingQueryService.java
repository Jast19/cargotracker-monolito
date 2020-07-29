package co.jast.monolito.routing.application.internal.queryservices;


import co.jast.monolito.routing.domain.model.aggregates.Voyage;
import co.jast.monolito.routing.infrastructure.repositories.jpa.VoyageRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Application Service class for the Cargo Routing Query service
 */
@ApplicationScoped
public class CargoRoutingQueryService {

    @Inject
    private VoyageRepository voyageRepository; // Inject Dependencies

    /**
     * Returns all Voyages
     *
     * @return
     */
    @Transactional
    public List<Voyage> findAll() {
        return voyageRepository.findAll();
    }


}
