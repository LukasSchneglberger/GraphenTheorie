import java.io.File;

/**
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
public class Main {
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.read(new File("Linz_Suchproblem.csv"));

        int[] valuesVia = {21, 45, 50};

        Path path = graph.determineShortestPath(28, 30, 25);
        System.out.println("Start:");
        for (int nodeId : path.getNodeIds()) {
            System.out.print(nodeId + " ");
        }

        System.out.println();
        System.out.println("Length:");
        System.out.println(path.getPathLength());
    }
    
}
