package co.jast.monolito;

import co.jast.monolito.booking.interfaces.rest.CargoBookingController;
import co.jast.monolito.booking.interfaces.rest.CargoRoutingController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class CargoTrackerApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(CargoRoutingController.class, CargoBookingController.class));
    }
}
