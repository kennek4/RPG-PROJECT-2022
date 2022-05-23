
// import java.util.Scanner;

public class MapDriver {
    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);

        MapGraph map = new MapGraph();
        map.addNode("park");
        map.addNode("hospital");
        map.addNode("fireStation");
        map.addEdge("park", "hospital");
        map.addEdge("park", "fireStation");

        // System.out.println(map.getNode("park").enemyLevel);
        // map.getNode("park").enemyLevel = 5;
        // System.out.println(map.getNode("hospital").enemyLevel);

        String currentPos = "park";

        // System.out.println(map.getNode("park").lootType);

        // map.getNode("park").lootType = 3;

        // System.out.println(map.getNode("park").lootType);

        System.out.println(map.getNode("park").data.amount);
        System.out.println(map.getNode("park").data.tier);

        map.getNode("park").data = map.newData(1, 2);

        System.out.println(map.getNode("park").data.amount);
        System.out.println(map.getNode("park").data.tier);

    }
}
