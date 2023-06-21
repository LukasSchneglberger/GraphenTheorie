import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.*;

/**
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
@Data
@NoArgsConstructor
public class Graph { //TODO unit-Test schreiben und determineShortestPath 2

    List<Node> nodes = new ArrayList<>();

    PriorityQueue<Node> queue = new PriorityQueue<>();
    HashMap<Integer, Integer> distance = new HashMap<>();
    HashMap<Integer, Node> prev = new HashMap<>();//TODO prevs umbenennen

    /**
     * Reads a file that contains an adjacency matrix and stores it as a graph.
     *
     *@param adjacencyMatrix Graph as adjacency matrix.
     */
    public void read(File adjacencyMatrix) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(adjacencyMatrix)));
            br.readLine();
            int lineIndex = 1;
            String line;
            while (true) {
                line = br.readLine();
                if (line != null) {
                    String[] parts = line.split(";");
                    for (int i = 1; i < parts.length; i++) {
                        int pathLength = Integer.parseInt(parts[i]);
                        if (pathLength != 0) {
                            boolean isNode1 = false;
                            boolean isNode2 = false;
                            Edge edge = new Edge(pathLength, lineIndex, i);
                            Node fromNode = new Node(new ArrayList<>(List.of(edge)), lineIndex);
                            Node toNode = new Node(new ArrayList<>(), i);

                            for (Node node : nodes) {
                                if (node.getNodeId() == fromNode.getNodeId()) {
                                    node.getEdges().add(edge);
                                    isNode1 = true;
                                }
                                if (node.getNodeId() == toNode.getNodeId()) {
                                    isNode2 = true;
                                }
                            }

                            if(!isNode1) {
                                nodes.add(fromNode);
                            }
                            if(!isNode2) {
                                nodes.add(toNode);
                            }
                        }
                    }
                } else {
                    break;
                }
                lineIndex++;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
     * @param targetNodeId Node where the path eends.
     * @return Shortest path
     */
    public Path determineShortestPath(int sourceNodeId, int targetNodeId) {
        Path resultPath = new Path();

        List<Integer> allNodeIds = new ArrayList<>();
        for (Node node: nodes) {
            allNodeIds.add(node.getNodeId());
        }
        if(!allNodeIds.contains(targetNodeId)){
            return new Path();
        }

        for (Node node : nodes) {
            distance.put(node.getNodeId(), Integer.MAX_VALUE);
            prev.put(node.getNodeId(), null);
        }
        Node start = findNode(sourceNodeId);
        distance.replace(start.getNodeId(), 0);
        queue.add(start);

        while (!(queue.isEmpty())) {
            Node u = queue.poll(); //TODO umbenennen
            for (Edge edge : u.getEdges()) {
                int v = edge.getEnd();//TODO umbenennen
                int alt = distance.get(u.getNodeId()) + edge.getDistance();//TODO umbenennen
                if (alt < distance.get(v)) {
                    distance.replace(v, alt);
                    prev.replace(v, u);

                    Node nodeToAdd = findNode(v);
                    queue.add(nodeToAdd);
                }
            }
        }

        Node currentNode = findNode(targetNodeId);
        while (currentNode.getNodeId() != sourceNodeId) {
            resultPath.getNodes().add(0, currentNode.getNodeId());
            currentNode = prev.get(currentNode.getNodeId());
            if (currentNode == null) {
                return new Path();
            }
        }
        resultPath.setPathLength(distance.get(targetNodeId));
        resultPath.getNodes().add(0, sourceNodeId);
        return resultPath;
    }

    private Node findNode(int nodeId) {
        for (Node node : nodes) {
            if (node.getNodeId() == nodeId) {
                return node;
            }
        }
        return null;
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
