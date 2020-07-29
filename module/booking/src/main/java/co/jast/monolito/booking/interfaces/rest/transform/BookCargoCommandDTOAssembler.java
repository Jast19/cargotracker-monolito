package co.jast.monolito.booking.interfaces.rest.transform;

import co.jast.monolito.booking.domain.commands.BookCargoCommand;
import co.jast.monolito.booking.interfaces.rest.dto.BookCargoResource;

public class BookCargoCommandDTOAssembler {

    /**
     * Static method within the Assembler class
     *
     * @param bookCargoResource
     * @return BookCargoCommand Model
     */
    public static BookCargoCommand toCommandFromDTO(BookCargoResource bookCargoResource) {

        return new BookCargoCommand(
                bookCargoResource.getBookingAmount(),
                bookCargoResource.getOriginLocation(),
                bookCargoResource.getDestLocation(),
                java.sql.Date.valueOf(bookCargoResource.getDestArrivalDeadline()));
    }
}
