package co.jast.monolito.shared.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CargoHandledEvent {

    private CargoHandledEventData cargoHandledEventData;

    public CargoHandledEventData getContent() {
        return cargoHandledEventData;
    }

    public void setContent(CargoHandledEventData cargoHandledEventData) {
        this.cargoHandledEventData = cargoHandledEventData;
    }
}
