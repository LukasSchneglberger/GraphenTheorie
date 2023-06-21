import java.io.File;

/**
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
public class Main {
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.read(new File("Linz_Suchproblem.csv"));

        Path path = graph.determineShortestPath(28, 7);
        System.out.println("Start:");
        for (int nodeId : path.getNodeIds()) {
            System.out.print(nodeId + " ");
        }

        System.out.println();
        System.out.println("Length:");
        System.out.println(path.getPathLength());
    }
    
}
