import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    public void determineShortestPathTestWithNull(){
        Graph testGraph = new Graph();
        testGraph.read(new File("Linz_Suchproblem.csv"));

        Path p = testGraph.determineShortestPath(1, 55);
        assertEquals(new Path(), p);


        Path testPath = testGraph.determineShortestPath(53, 12);

        Path correctPath = new Path();
        correctPath.getNodes().add(53);
        correctPath.getNodes().add(52);
        correctPath.getNodes().add(54);
        correctPath.getNodes().add(42);
        correctPath.getNodes().add(9);
        correctPath.getNodes().add(10);
        correctPath.getNodes().add(11);
        correctPath.getNodes().add(12);
        correctPath.setPathLength(930);


        assertEquals(correctPath, testPath);


    } @Test
    public void determineShortestPathTest(){
        Graph testGraph = new Graph();
        testGraph.read(new File("Linz_Suchproblem.csv"));

        Path testPath = testGraph.determineShortestPath(53, 12);

        Path correctPath = new Path();
        correctPath.getNodes().add(53);
        correctPath.getNodes().add(52);
        correctPath.getNodes().add(54);
        correctPath.getNodes().add(42);
        correctPath.getNodes().add(9);
        correctPath.getNodes().add(10);
        correctPath.getNodes().add(11);
        correctPath.getNodes().add(12);
        correctPath.setPathLength(930);


        assertEquals(correctPath, testPath);


    }

    @Test
    public void getNodeIdsTest(){
        Path testPath = new Path();
        testPath.getNodes().add(53);
        testPath.getNodes().add(52);
        testPath.getNodes().add(54);
        testPath.getNodes().add(42);
        testPath.getNodes().add(9);
        testPath.getNodes().add(10);
        testPath.getNodes().add(11);
        testPath.getNodes().add(12);
        int[] testArray = testPath.getNodeIds();

        int[] correctArray= {53, 52, 54, 42, 9, 10, 11, 12};

        assertTrue(Arrays.equals(correctArray, testArray));
    }

    @Test
    public void computeTest(){
        Path testPath = new Path();
        testPath.getNodes().add(53);
        testPath.getNodes().add(52);
        testPath.getNodes().add(54);
        testPath.getNodes().add(42);
        testPath.getNodes().add(9);
        testPath.getNodes().add(10);
        testPath.getNodes().add(11);
        testPath.getNodes().add(12);
        testPath.setPathLength(930);
        double weight = testPath.computeWeight();

        assertEquals(930, weight);
    }


    @Test
    public void determineShortestPathVia(){
        Graph testGraph = new Graph();
        testGraph.read(new File("Linz_Suchproblem.csv"));

        Path testPath = testGraph.determineShortestPath(28, 30, 25);

        Path correctPath = new Path();
        correctPath.getNodes().add(28);
        correctPath.getNodes().add(27);
        correctPath.getNodes().add(25);
        correctPath.getNodes().add(56);
        correctPath.getNodes().add(30);
        correctPath.setPathLength(280);


        assertEquals(correctPath, testPath);
    }

    @Test
    public void determineShortestPathViaWithNewPath(){
        Graph testGraph = new Graph();
        testGraph.read(new File("Linz_Suchproblem.csv"));

        Path testPath = testGraph.determineShortestPath(28, 30, 58);

        Path correctPath = new Path();
        assertEquals(correctPath, testPath);
    }


}
