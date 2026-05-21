import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch<V> extends Search<V> {

    private Set<Vertex<V>> visited;

    public DepthFirstSearch(WeightedGraph<V> graph,
                            Vertex<V> start) {

        super(graph, start);
        visited = new HashSet<>();
    }

    @Override
    public void search() {
        dfs(start);
    }

    private void dfs(Vertex<V> current) {

        visited.add(current);

        System.out.println(current);

        for (Vertex<V> neighbor :
                current.getAdjacentVertices().keySet()) {

            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }
}