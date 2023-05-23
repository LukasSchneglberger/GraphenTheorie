import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/*
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
@Data
@AllArgsConstructor
public class Edge {

    private int distance;
    private Node start;
    private Node end;
    
    public int getFirstNodeId() {
        return start.getNodeId();
    }
    
    public int getSecondNodeId() {
        return end.getNodeId();
    }


    @Override
    public String toString() {
        return "Edge{" +
                "distance=" + distance +
                ", start=" + start.getNodeId() +
                ", end=" + end.getNodeId() +
                '}';
    }
}
