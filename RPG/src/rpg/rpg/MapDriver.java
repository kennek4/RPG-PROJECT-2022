package rpg;

import java.util.Scanner;



public class MapDriver {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MapGraph map = new MapGraph();
        map.addNode("park");
        map.addNode("hospital");
        map.addNode("fireStation");
        map.addNode("dirtyRoad");
        map.addNode("splitRoad");
        map.addNode("warehouse");
        map.addNode("crackedRoad");
        map.addNode("jewelleryStore");
        map.addNode("factory");
        map.addNode("lumberStore");
        map.addNode("highway");
        map.addNode("checkpoint");
        map.addEdge("park", "hospital");
        map.addEdge("hospital", "dirtyRoad");
        map.addEdge("dirtyRoad", "fireStation");
        map.addEdge("fireStation", "splitRoad");
        map.addEdge("splitRoad", "warehouse");
        map.addEdge("splitRoad", "crackedRoad");
        map.addEdge("warehouse", "jewelleryStore");
        map.addEdge("jewelleryStore", "factory");
        map.addEdge("factory", "checkpoint");
        map.addEdge("crackedRoad", "lumberStore");
        map.addEdge("lumberStore", "highway");
        map.addEdge("highway", "checkpoint");

        // System.out.println(map.getNode("park").enemyLevel);
        // map.getNode("park").enemyLevel = 5;
        // System.out.println(map.getNode("hospital").enemyLevel);

        String currentPos = "park";

        while (true) {
        	System.out.println("You are at: " + currentPos);
            System.out.println("Where do you want to go?");
            System.out.println(map.getAdjList(currentPos));
            String choice = sc.next();
            currentPos = choice;
        }
    }
}

