package co.jast.monolito.shared.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@XmlRootElement
public class TransitPath implements Serializable {

    private List<TransitEdge> transitEdges;

    public TransitPath() {
        this.transitEdges = new ArrayList<>();
    }

}
