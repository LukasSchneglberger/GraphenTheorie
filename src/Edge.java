import lombok.Data;

/*
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
@Data
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
