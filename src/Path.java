/**
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
public class Path {
    
    /**
     * Returns the path as ordered array of nodeIds. If there is no path, the returned
     * array is empty (not null). If source and target nodeId are the same, the returned
     * path contains both nodeIds.
     *
     * @return Path as nodeId array
     */
    public int[] getNodeIds() {
        return new int[]{};
    }

    /**
     * Computes the weight of the path and returns it. The weight is defined as the sum
     * of its edge weights. If there is no path, the returned value is -1. If source and
     * target nodeId are the same, the returned value is 0.
     *
     * @return Path's weight
     */
    public double computeWeight() {
        return -2.0;
    }

}
