import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/*
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
@Data
@AllArgsConstructor
@ToString
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


    
}
