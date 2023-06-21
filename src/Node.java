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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Node implements Comparable<Node> {

    private List<Edge> edges;
    private int nodeId;

    @Override
    public int compareTo(Node o) {
        return this.getNodeId() - o.getNodeId();
    }
}
