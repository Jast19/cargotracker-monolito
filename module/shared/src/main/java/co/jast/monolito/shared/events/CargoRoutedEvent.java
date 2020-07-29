package co.jast.monolito.shared.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CargoRoutedEvent {

    private CargoRoutedEventData cargoRoutedEventData;

    public CargoRoutedEventData getContent() {
        return cargoRoutedEventData;
    }

    public void setContent(CargoRoutedEventData cargoRoutedEventData) {
        this.cargoRoutedEventData = cargoRoutedEventData;
    }
}
