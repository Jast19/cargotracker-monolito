package co.jast.monolito.shared.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransitEdge implements Serializable {

    private String voyageNumber;
    private String fromUnLocode;
    private String toUnLocode;
    private Date fromDate;
    private Date toDate;
}
