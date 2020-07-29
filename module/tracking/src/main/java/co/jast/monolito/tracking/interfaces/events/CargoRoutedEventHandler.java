package co.jast.monolito.tracking.interfaces.events;


import co.jast.monolito.shared.events.CargoRoutedEvent;
import co.jast.monolito.tracking.application.internal.commandservices.AssignTrackingIdCommandService;
import co.jast.monolito.tracking.interfaces.events.transform.TrackingDetailsCommandEventAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class CargoRoutedEventHandler {

    @Inject
    private AssignTrackingIdCommandService assignTrackingIdCommandService; // Application Service Dependency


    /**
     * Cargo Routed Event Handler Method
     *
     * @param event
     */

    @Transactional
    public void observeCargoRoutedEvent(@Observes CargoRoutedEvent event) {
        System.out.println("****Observing Cargo Routed Event***");
        assignTrackingIdCommandService.assignTrackingNumberToCargo(TrackingDetailsCommandEventAssembler
                .toCommandFromEvent(event));
    }
}
