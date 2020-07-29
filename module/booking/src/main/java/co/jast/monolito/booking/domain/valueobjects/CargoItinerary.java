package co.jast.monolito.booking.domain.valueobjects;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor
@Embeddable
public class CargoItinerary {

    public static final CargoItinerary EMPTY_ITINERARY = new CargoItinerary();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cargo_id")
    private List<Leg> legs = Collections.emptyList();

    public CargoItinerary(List<Leg> legs) {
        this.legs = legs;
    }

}
