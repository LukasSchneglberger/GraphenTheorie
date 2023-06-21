import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

/**
 * @author Valentin Zahrhuber, Lukas Schneglberger
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Edge implements Comparable<Edge> {

    private int distance;
    private int start;
    private int end;

    @Override
    public int compareTo(Edge o) {
        return this.distance - o.distance;
    }
}
