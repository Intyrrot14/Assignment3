public class Main {

    public static void main(String[] args) {

        WeightedGraph<String> graph =
                new WeightedGraph<>();

        Vertex<String> PARIS =
                new Vertex<>("PARIS");

        Vertex<String> ASTANA =
                new Vertex<>("ASTANA");

        Vertex<String> ITALY =
                new Vertex<>("ITALY");

        Vertex<String> NIGERIA =
                new Vertex<>("NIGERIA");

        Vertex<String> PORTUGAL =
                new Vertex<>("PORTUGAL");

        graph.addVertex(PARIS);
        graph.addVertex(ASTANA);
        graph.addVertex(ITALY);
        graph.addVertex(NIGERIA);
        graph.addVertex(PORTUGAL);

        graph.addEdge(PARIS, ASTANA, 1);
        graph.addEdge(PARIS, ITALY, 4);

        graph.addEdge(ASTANA, ITALY, 2);
        graph.addEdge(ASTANA, NIGERIA, 5);

        graph.addEdge(ITALY, NIGERIA, 1);

        graph.addEdge(NIGERIA, PORTUGAL, 3);

        System.out.println("BFS:");

        BreadthFirstSearch<String> bfs =
                new BreadthFirstSearch<>(
                        graph, PARIS
                );

        bfs.search();

        System.out.println();

        System.out.println("Dijkstra:");

        DijkstraSearch<String> dijkstra =
                new DijkstraSearch<>(
                        graph, PARIS
                );

        dijkstra.search();
    }
