import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Node {

    private List<Edge> edges;
    private int nodeId;


    public Node(int nodeID) {
        this.nodeId = nodeID;
    }
}
