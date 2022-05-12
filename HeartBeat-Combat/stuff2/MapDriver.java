package stuff2;

public class MapDriver {
    public static void main(String[] args) {
        MapGraph map = new MapGraph();
        map.addNode("park");
        map.addNode("hospital");
        map.addNode("fire station");
        map.addEdge("park", "hospital");
        map.addEdge("park", "fire station");

        System.out.println(map.getAdjList("park"));
    }
}
