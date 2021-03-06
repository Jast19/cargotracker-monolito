package co.jast.monolito.handling.interfaces.rest.transform;


import co.jast.monolito.handling.domain.commands.HandlingActivityRegistrationCommand;
import co.jast.monolito.handling.interfaces.rest.dto.HandlingActivityRegistrationResource;

/**
 * Assembler class to convert the Book Cargo Resource Data to the Book Cargo Model
 */
public class HandlingActivityRegistrationCommandDTOAssembler {

    /**
     * Static method within the Assembler class
     *
     * @param handlingActivityRegistrationResource
     * @return BookCargoCommand Model
     */
    public static HandlingActivityRegistrationCommand toCommandFromDTO(
            HandlingActivityRegistrationResource handlingActivityRegistrationResource) {

        return new HandlingActivityRegistrationCommand(
                handlingActivityRegistrationResource.getBookingId(),
                handlingActivityRegistrationResource.getVoyageNumber(),
                handlingActivityRegistrationResource.getUnLocode(),
                handlingActivityRegistrationResource.getHandlingType(),
                java.sql.Date.valueOf(handlingActivityRegistrationResource.getCompletionTime())
        );
    }
}
