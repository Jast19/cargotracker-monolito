package co.jast.monolito.booking.application.internal.commandservices;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;

@ApplicationScoped
public class ExampleCDI {

    public HashMap<Integer, String> value() {
        HashMap<Integer, String> example = new HashMap<>();
        example.put(1, "Home");
        example.put(2, "shared");
        example.put(3, "add-pain");
        return example;
    }

}
