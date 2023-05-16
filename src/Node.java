import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
@Data
@AllArgsConstructor
public class Node {

    private List<Edge> edges;
    private int nodeId;
    
}
