package co.jast.monolito.tracking.interfaces.events.transform;


import co.jast.monolito.shared.events.CargoHandledEvent;
import co.jast.monolito.shared.events.CargoHandledEventData;
import co.jast.monolito.tracking.domain.model.commands.AddTrackingEventCommand;

/**
 * Assembler class to convert the Cargo Routed Event to the Assign Tracking Number Command Model
 */
public class TrackingActivityCommandEventAssembler {

    /**
     * Static method within the Assembler class
     *
     * @param cargoHandledEvent
     * @return AssignTrackingNumberCommand Model
     */
    public static AddTrackingEventCommand toCommandFromEvent(CargoHandledEvent cargoHandledEvent) {
        CargoHandledEventData eventData = cargoHandledEvent.getContent();
        return new AddTrackingEventCommand(
                eventData.getBookingId(),
                eventData.getHandlingCompletionTime(),
                eventData.getHandlingType(),
                eventData.getHandlingLocation(),
                eventData.getVoyageNumber());
    }
}
