package stuff2;

public class MapDriver {
    public static void main(String[] args) {
        MapGraph map = new MapGraph();
        map.addNode("park");
        map.addNode("hospital");
        map.addNode("fire station");
        map.addEdge("park", "hospital");
        map.addEdge("park", "fire station");

        System.out.println(map.getNode("park").enemyLevel);
        map.getNode("park").enemyLevel = 10;
        System.out.println(map.getNode("park").enemyLevel);
        System.out.println(map.getAdjList("park"));
    }
}
