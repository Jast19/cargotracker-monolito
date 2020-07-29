package co.jast.monolito.booking.interfaces.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCargoResource {

    private int bookingAmount;
    private String originLocation;
    private String destLocation;
    private LocalDate destArrivalDeadline;
}
