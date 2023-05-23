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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Node {
    private List<Edge> edges = new ArrayList<>();
    private int nodeId;

    public Node(int nodeId) {
        this.nodeId = nodeId;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}
