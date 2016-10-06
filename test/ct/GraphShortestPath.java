package ct;


import org.junit.Before;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class GraphShortestPath {
    public static class Edge {
        public final int v0;
        public final int v1;
        public final int weight;

        public Edge(int v0, int v1, int weight) {
            this.v0 = v0;
            this.v1 = v1;
            this.weight = weight;
        }

    }

    // 1-based array
    public Collection<Edge>[] graph = new Collection[14];

    @Before
    public void init() {
        graph[0] = Collections.emptyList();
        graph[1] = Arrays.asList(new Edge(1,2,1), new Edge(1,6,2), new Edge(1,7,6));
        graph[2] = Arrays.asList(new Edge(2,4,2),new Edge(2,3,1),new Edge(2,5,4), new Edge(2,1,1));
        graph[3] = Arrays.asList(new Edge(3,2,1),new Edge(3,5,4));
        graph[4] = Arrays.asList(new Edge(4,2,2),new Edge(4,5,2),new Edge(4,6,1));
        graph[5] = Arrays.asList(new Edge(5,6,2),new Edge(5,4,2),new Edge(5,2,4),new Edge(5,3,4),new Edge(5,7,1));
        graph[6] = Arrays.asList(new Edge(6,1,2),new Edge(6,4,1),new Edge(6,5,2),new Edge(6,12,2));
        graph[7] = Arrays.asList(new Edge(7,5,1),new Edge(7,1,6),new Edge(7,8,3),new Edge(7,10,1),new Edge(7,12,5));
        graph[8] = Arrays.asList(new Edge(8,7,3),new Edge(8,9,2));
        graph[9] = Arrays.asList(new Edge(9,8,2),new Edge(9,11,1));
        graph[10] = Arrays.asList(new Edge(10,7,1),new Edge(10,11,1),new Edge(10,13,2),new Edge(10,12,3));
        graph[11] = Arrays.asList(new Edge(11,9,1),new Edge(11,10,1));
        graph[12] = Arrays.asList(new Edge(12,6,2),new Edge(12,5,4),new Edge(12,7,5),new Edge(12,10,3),new Edge(12,13,1));
        graph[13] = Arrays.asList(new Edge(13,13,1),new Edge(13,10,2));
    }

}
