package co.jast.monolito.booking.domain.entities;

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
public class Location {

    @Column(name = "origin_id")
    private String unLocCode;
}
