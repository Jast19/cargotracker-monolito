package co.jast.monolito.booking.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class LastCargoHandledEvent {

    // Null object pattern.
    public static final LastCargoHandledEvent EMPTY = new LastCargoHandledEvent();
    @Column(name = "last_handling_event_id")
    private Integer handlingEventId;
    @Column(name = "last_handling_event_type")
    private String handlingEventType;
    @Column(name = "last_handling_event_voyage")
    private String handlingEventVoyage;
    @Column(name = "last_handling_event_location")
    private String handlingEventLocation;

}
