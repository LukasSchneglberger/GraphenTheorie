import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
@Data
public class Path {

    private List<Integer> nodes = new ArrayList<>();
    private int pathLength = 0;

    /**
     * Returns the path as ordered array of nodeIds. If there is no path, the returned
     * array is empty (not null). If source and target nodeId are the same, the returned
     * path contains both nodeIds.
     *
     * @return Path as nodeId array
     */
    public int[] getNodeIds() {
        //If there is no path, the returned array is empty (not null)
        if (nodes.size() < 1) {
            return new int[]{};
        }

        //If source and target nodeId are the same, the returned path contains both nodeIds
        if (nodes.get(0) == nodes.get(nodes.size() - 1)) {
            return new int[]{
                    nodes.get(0),
                    nodes.get(nodes.size() - 1)
            };
        }

        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }
        return result;
    }

    /**
     * Computes the weight of the path and returns it. The weight is defined as the sum
     * of its edge weights. If there is no path, the returned value is -1. If source and
     * target nodeId are the same, the returned value is 0.
     *
     * @return Path's weight
     */
    public double computeWeight() {
        if (nodes.size() < 1) return -1;
        else if (nodes.get(0) == nodes.get(nodes.size() - 1)) return 0;
        else return pathLength;
    }

}
