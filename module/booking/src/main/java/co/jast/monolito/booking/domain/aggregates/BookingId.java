package co.jast.monolito.booking.domain.aggregates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BookingId implements Serializable {

    @Column(name = "booking_id")
    private String bookingId;

}
