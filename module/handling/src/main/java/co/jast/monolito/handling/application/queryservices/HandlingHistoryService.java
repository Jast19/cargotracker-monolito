package co.jast.monolito.handling.application.queryservices;


import co.jast.monolito.handling.domain.valueobjects.HandlingActivityHistory;
import co.jast.monolito.handling.infrastructure.repository.HandlingActivityRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Application Service which caters to all queries related to the Handling Activity Aggregate
 */
@ApplicationScoped
public class HandlingHistoryService {

    @Inject
    private HandlingActivityRepository handlingActivityRepository;

    @Transactional
    public HandlingActivityHistory getHandlingActivityHistory(String bookingId) {
        return handlingActivityRepository.lookupHandlingHistoryOfCargo(bookingId);
    }
}
