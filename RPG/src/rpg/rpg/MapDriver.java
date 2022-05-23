package rpg;

import java.util.List;
import java.util.Scanner;

import rpg.MapGraph.MapNode;



public class MapDriver {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MapGraph map = new MapGraph();
        map.addNode("park");
        map.getNode("park").data = map.newData(1, 1);
        map.addNode("hospital");
        map.getNode("hospital").data = map.newData(1, 2);
        map.addNode("fireStation");
        map.getNode("fireStation").data = map.newData(2, 1);
        map.addNode("dirtyRoad");
        map.getNode("dirtyRoad").data = map.newData(2, 1);
        map.addNode("splitRoad");
        map.getNode("splitRoad").data = map.newData(0, 0);
        map.addNode("warehouse");
        map.getNode("warehouse").data = map.newData(1, 3);
        map.addNode("crackedRoad");
        map.getNode("crackedRoad").data = map.newData(0, 0);
        map.addNode("jewelleryStore");
        map.getNode("jewelleryStore").data = map.newData(3, 1);
        map.addNode("factory");
        map.getNode("factory").data = map.newData(4, 1);
        map.addNode("lumberStore");
        map.getNode("lumberStore").data = map.newData(2, 2);
        map.addNode("highway");
        map.getNode("highway").data = map.newData(4, 1);
        map.addNode("checkpoint");
        map.getNode("dirtyRoad").data = map.newData(5, 1);
        
        
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

        
        MapGraph map2 = new MapGraph();
        map2.addNode("highway");
        map2.getNode("highway").data = map.newData(2, 1);
        map2.addNode("carRental");
        map2.getNode("carRental").data = map.newData(2, 2);
        map2.addNode("convenienceStore");
        map2.getNode("convenienceStore").data = map.newData(1, 3);
        map2.addNode("gym");
        map2.getNode("gym").data = map.newData(3, 1);
        map2.addNode("dryRoad");
        map2.getNode("dryRoad").data = map.newData(0, 0);
        map2.addNode("muddyRoad");
        map2.getNode("muddyRoad").data = map.newData(2, 3);
        map2.addNode("busShelter");
        map2.getNode("busShelter").data = map.newData(4, 1);
        map2.addNode("rockyRoad");
        map2.getNode("rockyRoad").data = map.newData(3, 2);
        map2.addNode("bridge");
        map2.getNode("bridge").data = map.newData(5, 1);
        
        map2.addEdge("highway", "carRental");
        map2.addEdge("carRental", "convenienceStore");
        map2.addEdge("convenienceStore", "gym");
        map2.addEdge("gym", "dryRoad");
        map2.addEdge("dryRoad", "muddyRoad");
        map2.addEdge("muddyRoad", "busShelter");
        map2.addEdge("busShelter", "rockyRoad");
        map2.addEdge("rockyRoad", "bridge");
       
        String currentPos = "highway";

        while (true) {       	
        	System.out.println(map2.getNode("highway").data.amount);
        	System.out.println(map2.getNode("highway").data.tier);
        	System.out.println("You are at: " + currentPos);
            System.out.println("Where do you want to go?");
            System.out.println(map2.getAdjList(currentPos));
            String choice = sc.next();
            currentPos = choice;
        }
    }
   
}

