package co.jast.monolito.tracking.interfaces.events;


import co.jast.monolito.shared.events.CargoHandledEvent;
import co.jast.monolito.shared.events.CargoHandledEventData;
import co.jast.monolito.tracking.application.internal.commandservices.AssignTrackingIdCommandService;
import co.jast.monolito.tracking.interfaces.events.transform.TrackingActivityCommandEventAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class CargoHandledEventHandler {

    @Inject
    private AssignTrackingIdCommandService assignTrackingIdCommandService; // Application Service Dependency


    /**
     * Cargo Handled Event handler
     *
     * @param event
     */
    @Transactional
    public void observeCargoHandledEvent(@Observes CargoHandledEvent event) {
        System.out.println("***Cargo Handled Event****" + event.getContent());
        CargoHandledEventData eventData = event.getContent();
        System.out.println(eventData.getBookingId());
        System.out.println(eventData.getHandlingLocation());
        System.out.println(eventData.getHandlingCompletionTime());
        System.out.println(eventData.getHandlingType());
        System.out.println(eventData.getVoyageNumber());
        assignTrackingIdCommandService.addTrackingEvent(
                TrackingActivityCommandEventAssembler.toCommandFromEvent(event));
    }


}
