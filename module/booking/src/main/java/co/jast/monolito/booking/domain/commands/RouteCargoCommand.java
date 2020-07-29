package co.jast.monolito.booking.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteCargoCommand {

    private String cargoBookingId;
}
