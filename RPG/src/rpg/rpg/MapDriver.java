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
        
        MapGraph map3 = new MapGraph();
        map3.addNode("bridge");
        map3.getNode("bridge").data = map.newData(1, 3);
        map3.addNode("dirtyRoad");
        map3.getNode("dirtyRoad").data = map.newData(2, 2);
        map3.addNode("chickenShop");
        map3.getNode("chickenShop").data = map.newData(3, 1);
        map3.addNode("postOffice");
        map3.getNode("postOffice").data = map.newData(3, 2);
        map3.addNode("motel");
        map3.getNode("motel").data = map.newData(0, 0);
        map3.addNode("largePark");
        map3.getNode("largePark").data = map.newData(2, 3);
        map3.addNode("cafe");
        map3.getNode("cafe").data = map.newData(4, 1);
        map3.addNode("street");
        map3.getNode("street").data = map.newData(0, 0);
        map3.addNode("alley");
        map3.getNode("alley").data = map.newData(3, 3);
        map3.addNode("restaurant");
        map3.getNode("restaurant").data = map.newData(4, 2);
        map3.addNode("crackedRoad");
        map3.getNode("crackedRoad").data = map.newData(3, 3);
        map3.addNode("longBridge");
        map3.getNode("longBridge").data = map.newData(5, 1);
        
        map3.addEdge("bridge", "dirtyRoad");
        map3.addEdge("dirtyRoad", "chickenShop");
        map3.addEdge("chickenShop", "postOffice");
        map3.addEdge("postOffice", "motel");
        map3.addEdge("motel", "largePark");
        map3.addEdge("largePark", "cafe");
        map3.addEdge("cafe", "street");
        map3.addEdge("street", "alley");
        map3.addEdge("alley", "restaurant");
        map3.addEdge("restaurant", "crackedRoad");
        map3.addEdge("crackedRoad", "longBridge");
        
        MapGraph map4 = new MapGraph();
        map4.addNode("bridge");
        map4.getNode("bridge").data = map.newData(1, 3);
        map4.addNode("junction");
        map4.getNode("junction").data = map.newData(2, 2);
        map4.addNode("bank");
        map4.getNode("bank").data = map.newData(3, 2);
        map4.addNode("supermarket");
        map4.getNode("supermarket").data = map.newData(2, 3);
        map4.addNode("desolateRoad");
        map4.getNode("desolateRoad").data = map.newData(0, 0);
        map4.addNode("alley");
        map4.getNode("alley").data = map.newData(3, 2);
        map4.addNode("subwayStation");
        map4.getNode("subwayStation").data = map.newData(4, 1);
        map4.addNode("gasStation");
        map4.getNode("gasStation").data = map.newData(3, 3);
        map4.addNode("street");
        map4.getNode("street").data = map.newData(2, 3);
        map4.addNode("brokenRoad");
        map4.getNode("brokenRoad").data = map.newData(0, 0);
        map4.addNode("mechanicShop");
        map4.getNode("mechanicShop").data = map.newData(4, 2);
        map4.addNode("powerStation");
        map4.getNode("powerStation").data = map.newData(5, 1);
        
        map4.addEdge("bridge", "junction");
        map4.addEdge("junction", "bank");
        map4.addEdge("bank", "supermarket");
        map4.addEdge("supermarket", "desolateRoad");
        map4.addEdge("desolateRoad", "alley");
        map4.addEdge("alley", "subwayStation");
        map4.addEdge("subwayStation", "gasStation");
        map4.addEdge("gasStation", "street");
        map4.addEdge("street", "brokenRoad");
        map4.addEdge("brokenRoad", "mechanicShop");
        map4.addEdge("mechanicShop", "powerStation");
        
        MapGraph map5 = new MapGraph();
        map5.addNode("street");
        map5.getNode("street").data = map.newData(1, 3);
        map5.addNode("elementarySchool");
        map5.getNode("elementarySchool").data = map.newData(2, 2);
        map5.addNode("boulevard");
        map5.getNode("boulevard").data = map.newData(2, 3);
        map5.addNode("groceryStore");
        map5.getNode("groceryStore").data = map.newData(3, 2);
        map5.addNode("sportComplex");
        map5.getNode("sportComplex").data = map.newData(3, 3);
        map5.addNode("church");
        map5.getNode("church").data = map.newData(0, 0);
        map5.addNode("alley");
        map5.getNode("alley").data = map.newData(4, 2);
        map5.addNode("crackedRoad");
        map5.getNode("crackedRoad").data = map.newData(2, 3);
        map5.addNode("beach");
        map5.getNode("beach").data = map.newData(4, 3);
        map5.addNode("park");
        map5.getNode("park").data = map.newData(0, 0);
        map5.addNode("longRoad");
        map5.getNode("longRoad").data = map.newData(4, 2);
        map5.addNode("bridge");
        map5.getNode("bridge").data = map.newData(5, 2);
        
        map5.addEdge("street", "elementarySchool");
        map5.addEdge("elementarySchool", "boulevard");
        map5.addEdge("boulevard", "groceryStore");
        map5.addEdge("groceryStore", "sportComplex");
        map5.addEdge("sportComplex", "church");
        map5.addEdge("church", "alley");
        map5.addEdge("alley", "crackedRoad");
        map5.addEdge("crackedRoad", "beach");
        map5.addEdge("beach", "park");
        map5.addEdge("park", "longRoad");
        map5.addEdge("longRoad", "bridge");
        
        MapGraph map6 = new MapGraph();
        map6.addNode("bridge");
        map6.getNode("bridge").data = map.newData(1, 3);
        map6.addNode("convenienceStore");
        map6.getNode("convenienceStore").data = map.newData(2, 2);
        map6.addNode("gasStation");
        map6.getNode("gasStation").data = map.newData(3, 2);
        map6.addNode("pharmacy");
        map6.getNode("pharmacy").data = map.newData(3, 3);
        map6.addNode("highSchool");
        map6.getNode("highSchool").data = map.newData(4, 2);
        map6.addNode("cafe");
        map6.getNode("cafe").data = map.newData(4, 3);
        map6.addNode("road");
        map6.getNode("road").data = map.newData(0, 0);
        map6.addNode("butcherShop");
        map6.getNode("butcherShop").data = map.newData(5, 1);
        map6.addNode("hospital");
        map6.getNode("hospital").data = map.newData(5, 2);
        
        map6.addEdge("bridge", "convenienceStore");
        map6.addEdge("convenienceStore", "gasStation");
        map6.addEdge("gasStation", "pharmacy");
        map6.addEdge("pharmacy", "highSchool");
        map6.addEdge("pharmacy", "cafe");
        map6.addEdge("cafe", "road");
        map6.addEdge("road", "butcherShop");
        map6.addEdge("butcherShop", "hospital");
        
        String currentPos = "bridge";

        while (true) {       	
        	//System.out.println(map5.getNode("street").data.amount);
        	//System.out.println(map5.getNode("street").data.tier);
        	System.out.println("You are at: " + currentPos);
            System.out.println("Where do you want to go?");
            System.out.println(map6.getAdjList(currentPos));
            String choice = sc.next();
            currentPos = choice;
            
        }
    }
   
}

