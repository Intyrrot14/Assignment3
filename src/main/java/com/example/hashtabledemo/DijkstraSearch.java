import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {

    public DijkstraSearch(WeightedGraph<V> graph,
                          Vertex<V> start) {

        super(graph, start);
    }

    @Override
    public void search() {

        Map<Vertex<V>, Double> distances =
                new HashMap<>();

        for (Vertex<V> vertex :
                graph.getVertices()) {

            distances.put(vertex,
                    Double.MAX_VALUE);
        }

        distances.put(start, 0.0);

        PriorityQueue<Vertex<V>> pq =
                new PriorityQueue<>(
                        Comparator.comparingDouble(
                                distances::get
                        )
                );

        pq.add(start);

        while (!pq.isEmpty()) {

            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> entry :
                    current.getAdjacentVertices().entrySet()) {

                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                double newDistance =
                        distances.get(current) + weight;

                if (newDistance <
                        distances.get(neighbor)) {

                    distances.put(neighbor,
                            newDistance);

                    pq.remove(neighbor);
                    pq.add(neighbor);
                }
            }
        }

        System.out.println(
                "Shortest distances:"
        );

        for (Map.Entry<Vertex<V>, Double> entry :
                distances.entrySet()) {

            System.out.println(
                    start + " -> " +
                            entry.getKey() + " = " +
                            entry.getValue()
            );
        }
    }
}