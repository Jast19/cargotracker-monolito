package co.jast.monolito.shared.events;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CargoHandledEventData {

    private String bookingId;
    private String handlingType;
    private Date handlingCompletionTime;
    private String handlingLocation;
    private String voyageNumber;
}
