import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph,
                              Vertex<V> start) {

        super(graph, start);
    }

    @Override
    public void search() {

        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {

            Vertex<V> current = queue.poll();

            System.out.println(current);

            for (Vertex<V> neighbor :
                    current.getAdjacentVertices().keySet()) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}