import java.io.*;
import java.util.*;

/**
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
public class Graph {

    Map values = new HashMap<Integer, Integer>();
    List<Edge> edges = new ArrayList<>();
    Map<Integer, Node> nodes = new HashMap<>();
    public Graph() {

    }



    /**
     * Reads a file that contains an adjacency matrix and stores it as a graph.
     *
     *@param adjacencyMatrix Graph as adjacency matrix.
     */
    public void read(File adjacencyMatrix) {

        String distance= null;
        int start;
        int end;
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(adjacencyMatrix.getAbsolutePath())));
            String[] firstRow = br.readLine().split(";");
            for (int i = 1; i < firstRow.length+1; i++) {
                String line = br.readLine();
                if(line == null) {
                    return;
                }
                String[] row = line.split(";");

                for (int j = 1; j < row.length; j++) {

                    if(!(row[j].equals("0"))){
                        distance = row[j];
                        start = i;
                        end = j;
                        Node node1 = new Node();
                        node1.setNodeId(start);
                        Node node2 = new Node();
                        node2.setNodeId(end);
                        Edge edge = new Edge(Integer.parseInt(distance), node1, node2);
                        edges.add(edge);

                        System.out.println(edge.toString());
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }






    /**
     * Determines the shortest path between source nodeId and target nodeId and returns it
     * as path. The shortest path is defined as the path with the minimum sum of
     * edge weighs. If there is no path between the given nodeIds, the returned
     * path is empty (not null). If source and target nodeId are the same, the returned
     * path contains both nodeIds.
     *
     * @param sourceNodeId Node where the path starts.
     * @param targetNodeId Node where the path ends.
     * @return Shortest path
     */
    public Path determineShortestPath(int sourceNodeId, int targetNodeId) {
        int[] shortestNode = determineNextShortestDistance(sourceNodeId);

        values.put(shortestNode[0], shortestNode[1]);

        for (Object keys : values.keySet())
        {
            System.out.println(keys);
            System.out.println(values.get(keys));
        }

        return new Path();



    }

    public int[] determineNextShortestDistance(int nodeID){
        int[] result = new int[2];
        int nextShortestID = Integer.MAX_VALUE;
        int shortestDistance = Integer.MAX_VALUE;
        for (Edge e : edges) {
            if(e.getFirstNodeId() == nodeID){
                if(e.getDistance() < nextShortestID){
                    nextShortestID = e.getSecondNodeId();
                    shortestDistance = e.getDistance();
                }
            }
        }

        result[0] = nextShortestID;
        result[1] = shortestDistance;
        return result;

    }





    /**
     * Determines the shortest path between source nodeId and target nodeId, considering
     * all via NodeIds in the given order, and returns it as path. The shortest path is
     * defined as the path with the minimum sum of edge weighs. If there is no path
     * between the given nodeIds, the returned path is empty (not null). If source and
     * target nodeId are the same, the returned path contains both nodeIds.
     *
     * @param sourceNodeId Node where the path starts.
     * @param targetNodeId Node where the path ends.
     * @param viaNodeIds Array of ordered via nodes.
     * @return Shortest path
     */
    public Path determineShortestPath(int sourceNodeId, int targetNodeId, int... viaNodeIds) {
        return new Path();
    }

    /**
     * Determines the maximum flow between source nodeId and target nodeId. The maximum
     * flow is defined as the maximum weight sum of all possible paths.
     *
     * @param sourceNodeId Node where the flow starts.
     * @param targetNodeId Node where the flow ends.
     * @return Maximum flow
     */
    public double determineMaximumFlow(int sourceNodeId, int targetNodeId) {
        return -1.0;
    }

    /**
     * Determines all edges that are used by the maximum flow and have a capacity of zero
     * (aka no weight) left. If there is no path between the given nodeIds, the
     * returned list is empty (not null).
     * 
     * @param sourceNodeId ode where the flow starts.
     * @param targetNodeId Node where the flow ends.
     * @return List of edges with no capacity left
     */
    public List<Edge> determineBottlenecks(int sourceNodeId, int targetNodeId) {
        return new ArrayList<>();
    }

}
