import java.io.File;

/**
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
public class Main {
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.read(new File("Linz_Suchproblem.csv"));
    }
    
}
