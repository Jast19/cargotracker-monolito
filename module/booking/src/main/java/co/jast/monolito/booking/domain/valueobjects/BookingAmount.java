package co.jast.monolito.booking.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BookingAmount {

    @Column(name = "booking_amount", unique = true, updatable= false)
    private Integer bookingAmount;
}
