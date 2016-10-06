package ct;


import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class GraphTraversal {
    Map<Integer,List<Integer>> graph = new TreeMap<Integer,List<Integer>>();

    @Before
    public void init() {
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1));
    }

    @Test
    public void testTraversal() {
        Set<Integer> nodes = traverse(graph);
    }

    private Set<Integer> traverse(Map<Integer, List<Integer>> graph) {
        Set<Integer> seen = new TreeSet<Integer>();

        for (Integer node : graph.keySet()) {
            if (!seen.contains(node)) {
                visit(graph, seen, node);
            }
        }
        return seen;
    }

    private void visit(Map<Integer, List<Integer>> graph, Set<Integer> seen, Integer node) {
        seen.add(node);
        for (Integer subnode : graph.get(node)) {
            if (!seen.contains(subnode)) {
                seen.add(node);
                visit(graph, seen, subnode);
            }
        }
    }

    @Test
    public void nonRecursiveTraversal() {
        Set<Integer> seen = new TreeSet<Integer>();
        List<Integer> stack = new ArrayList();

        for (Integer node : graph.keySet()) {
            stack.add(node);
        }
        while (!stack.isEmpty()) {
            Integer node = stack.remove(0);
            if (!seen.contains(node)) {
                seen.add(node);
                for (Integer subnode : graph.get(node)) {
                    stack.add(subnode);
                }
            }
        }

        assertEquals(graph.keySet(), seen);
    }

}
