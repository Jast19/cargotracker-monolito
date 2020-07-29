package co.jast.monolito.handling.domain.valueobjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Location class represented by a unique 5-diigit UN Location code.
 */
@Embeddable
public class Location {

    @Column(name = "location")
    private String unLocCode;

    public Location() {
    }

    public Location(String unLocCode) {
        this.unLocCode = unLocCode;
    }

    public String getUnLocCode() {
        return this.unLocCode;
    }

    public void setUnLocCode(String unLocCode) {
        this.unLocCode = unLocCode;
    }
}
