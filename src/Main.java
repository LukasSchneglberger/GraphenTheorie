import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
public class Main {
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        try {
            graph.read(null);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
}
