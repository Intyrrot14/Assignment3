public abstract class Search<V> {

    protected WeightedGraph<V> graph;
    protected Vertex<V> start;

    public Search(WeightedGraph<V> graph,
                  Vertex<V> start) {

        this.graph = graph;
        this.start = start;
    }

    public abstract void search();
}