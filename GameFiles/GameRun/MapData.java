package GameRun;

public class MapData {

    MapGraph area1;
    MapGraph area2;
    MapGraph area3;
    MapGraph area4;
    MapGraph area5;
    MapGraph area6;

    public MapData() {

        area1 = new MapGraph();
        area1.addNode("park");
        area1.getNode("park").data.enemyAmount = 1;
        area1.getNode("park").data.tier = 1;

        area1.addNode("hospital");
        area1.getNode("hospital").data.enemyAmount = 0;
        area1.getNode("hospital").data.tier = 0;

        area1.addNode("fireStation");
        area1.getNode("fireStation").data.enemyAmount = 1;
        area1.getNode("fireStation").data.tier = 2;

        area1.addNode("dirtyRoad");
        area1.getNode("dirtyRoad").data.enemyAmount = 1;
        area1.getNode("dirtyRoad").data.tier = 2;

        area1.addNode("splitRoad");
        area1.getNode("splitRoad").data.enemyAmount = 0;
        area1.getNode("splitRoad").data.tier = 0;

        area1.addNode("warehouse");
        area1.getNode("warehouse").data.enemyAmount = 3;
        area1.getNode("warehouse").data.tier = 1;

        area1.addNode("crackedRoad");
        area1.getNode("crackedRoad").data.enemyAmount = 0;
        area1.getNode("crackedRoad").data.tier = 0;

        area1.addNode("jewelleryStore");
        area1.getNode("jewelleryStore").data.enemyAmount = 1;
        area1.getNode("jewelleryStore").data.tier = 3;

        area1.addNode("factory");
        area1.getNode("factory").data.enemyAmount = 1;
        area1.getNode("factory").data.tier = 4;

        area1.addNode("lumberStore");
        area1.getNode("lumberStore").data.enemyAmount = 2;
        area1.getNode("lumberStore").data.tier = 2;

        area1.addNode("highway");
        area1.getNode("highway").data.enemyAmount = 1;
        area1.getNode("highway").data.tier = 4;

        area1.addNode("checkpoint");
        area1.getNode("checkpoint").data.enemyAmount = 1;
        area1.getNode("checkpoint").data.tier = 5;

        area1.addEdge("park", "hospital");
        area1.addEdge("hospital", "dirtyRoad");
        area1.addEdge("dirtyRoad", "fireStation");
        area1.addEdge("fireStation", "splitRoad");
        area1.addEdge("splitRoad", "warehouse");
        area1.addEdge("splitRoad", "crackedRoad");
        area1.addEdge("warehouse", "jewelleryStore");
        area1.addEdge("jewelleryStore", "factory");
        area1.addEdge("factory", "checkpoint");
        area1.addEdge("crackedRoad", "lumberStore");
        area1.addEdge("lumberStore", "highway");
        area1.addEdge("highway", "checkpoint");

        System.out.println(area1.getAdjList("hospital"));

        area2 = new MapGraph();
        area2.addNode("highway");
        area2.getNode("highway").data = area1.newData(2, 1);
        area2.addNode("carRental");
        area2.getNode("carRental").data = area1.newData(2, 2);
        area2.addNode("convenienceStore");
        area2.getNode("convenienceStore").data = area1.newData(1, 3);
        area2.addNode("gym");
        area2.getNode("gym").data = area1.newData(3, 1);
        area2.addNode("dryRoad");
        area2.getNode("dryRoad").data = area1.newData(0, 0);
        area2.addNode("muddyRoad");
        area2.getNode("muddyRoad").data = area1.newData(2, 3);
        area2.addNode("busShelter");
        area2.getNode("busShelter").data = area1.newData(4, 1);
        area2.addNode("rockyRoad");
        area2.getNode("rockyRoad").data = area1.newData(3, 2);
        area2.addNode("bridge");
        area2.getNode("bridge").data = area1.newData(5, 1);

        area2.addEdge("highway", "carRental");
        area2.addEdge("carRental", "convenienceStore");
        area2.addEdge("convenienceStore", "gym");
        area2.addEdge("gym", "dryRoad");
        area2.addEdge("dryRoad", "muddyRoad");
        area2.addEdge("muddyRoad", "busShelter");
        area2.addEdge("busShelter", "rockyRoad");
        area2.addEdge("rockyRoad", "bridge");

        area3 = new MapGraph();
        area3.addNode("bridge");
        area3.getNode("bridge").data = area1.newData(1, 3);
        area3.addNode("dirtyRoad");
        area3.getNode("dirtyRoad").data = area1.newData(2, 2);
        area3.addNode("chickenShop");
        area3.getNode("chickenShop").data = area1.newData(3, 1);
        area3.addNode("postOffice");
        area3.getNode("postOffice").data = area1.newData(3, 2);
        area3.addNode("motel");
        area3.getNode("motel").data = area1.newData(0, 0);
        area3.addNode("largePark");
        area3.getNode("largePark").data = area1.newData(2, 3);
        area3.addNode("cafe");
        area3.getNode("cafe").data = area1.newData(4, 1);
        area3.addNode("street");
        area3.getNode("street").data = area1.newData(0, 0);
        area3.addNode("alley");
        area3.getNode("alley").data = area1.newData(3, 3);
        area3.addNode("restaurant");
        area3.getNode("restaurant").data = area1.newData(4, 2);
        area3.addNode("crackedRoad");
        area3.getNode("crackedRoad").data = area1.newData(3, 3);
        area3.addNode("longBridge");
        area3.getNode("longBridge").data = area1.newData(5, 1);

        area3.addEdge("bridge", "dirtyRoad");
        area3.addEdge("dirtyRoad", "chickenShop");
        area3.addEdge("chickenShop", "postOffice");
        area3.addEdge("postOffice", "motel");
        area3.addEdge("motel", "largePark");
        area3.addEdge("largePark", "cafe");
        area3.addEdge("cafe", "street");
        area3.addEdge("street", "alley");
        area3.addEdge("alley", "restaurant");
        area3.addEdge("restaurant", "crackedRoad");
        area3.addEdge("crackedRoad", "longBridge");

        area4 = new MapGraph();
        area4.addNode("bridge");
        area4.getNode("bridge").data = area1.newData(1, 3);
        area4.addNode("junction");
        area4.getNode("junction").data = area1.newData(2, 2);
        area4.addNode("bank");
        area4.getNode("bank").data = area1.newData(3, 2);
        area4.addNode("supermarket");
        area4.getNode("supermarket").data = area1.newData(2, 3);
        area4.addNode("desolateRoad");
        area4.getNode("desolateRoad").data = area1.newData(0, 0);
        area4.addNode("alley");
        area4.getNode("alley").data = area1.newData(3, 2);
        area4.addNode("subwayStation");
        area4.getNode("subwayStation").data = area1.newData(4, 1);
        area4.addNode("gasStation");
        area4.getNode("gasStation").data = area1.newData(3, 3);
        area4.addNode("street");
        area4.getNode("street").data = area1.newData(2, 3);
        area4.addNode("brokenRoad");
        area4.getNode("brokenRoad").data = area1.newData(0, 0);
        area4.addNode("mechanicShop");
        area4.getNode("mechanicShop").data = area1.newData(4, 2);
        area4.addNode("powerStation");
        area4.getNode("powerStation").data = area1.newData(5, 1);

        area4.addEdge("bridge", "junction");
        area4.addEdge("junction", "bank");
        area4.addEdge("bank", "supermarket");
        area4.addEdge("supermarket", "desolateRoad");
        area4.addEdge("desolateRoad", "alley");
        area4.addEdge("alley", "subwayStation");
        area4.addEdge("subwayStation", "gasStation");
        area4.addEdge("gasStation", "street");
        area4.addEdge("street", "brokenRoad");
        area4.addEdge("brokenRoad", "mechanicShop");
        area4.addEdge("mechanicShop", "powerStation");

        area5 = new MapGraph();
        area5.addNode("street");
        area5.getNode("street").data = area1.newData(1, 3);
        area5.addNode("elementarySchool");
        area5.getNode("elementarySchool").data = area1.newData(2, 2);
        area5.addNode("boulevard");
        area5.getNode("boulevard").data = area1.newData(2, 3);
        area5.addNode("groceryStore");
        area5.getNode("groceryStore").data = area1.newData(3, 2);
        area5.addNode("sportComplex");
        area5.getNode("sportComplex").data = area1.newData(3, 3);
        area5.addNode("church");
        area5.getNode("church").data = area1.newData(0, 0);
        area5.addNode("alley");
        area5.getNode("alley").data = area1.newData(4, 2);
        area5.addNode("crackedRoad");
        area5.getNode("crackedRoad").data = area1.newData(2, 3);
        area5.addNode("beach");
        area5.getNode("beach").data = area1.newData(4, 3);
        area5.addNode("park");
        area5.getNode("park").data = area1.newData(0, 0);
        area5.addNode("longRoad");
        area5.getNode("longRoad").data = area1.newData(4, 2);
        area5.addNode("bridge");
        area5.getNode("bridge").data = area1.newData(5, 2);

        area5.addEdge("street", "elementarySchool");
        area5.addEdge("elementarySchool", "boulevard");
        area5.addEdge("boulevard", "groceryStore");
        area5.addEdge("groceryStore", "sportComplex");
        area5.addEdge("sportComplex", "church");
        area5.addEdge("church", "alley");
        area5.addEdge("alley", "crackedRoad");
        area5.addEdge("crackedRoad", "beach");
        area5.addEdge("beach", "park");
        area5.addEdge("park", "longRoad");
        area5.addEdge("longRoad", "bridge");

        area6 = new MapGraph();
        area6.addNode("bridge");
        area6.getNode("bridge").data = area1.newData(1, 3);
        area6.addNode("convenienceStore");
        area6.getNode("convenienceStore").data = area1.newData(2, 2);
        area6.addNode("gasStation");
        area6.getNode("gasStation").data = area1.newData(3, 2);
        area6.addNode("pharmacy");
        area6.getNode("pharmacy").data = area1.newData(3, 3);
        area6.addNode("highSchool");
        area6.getNode("highSchool").data = area1.newData(4, 2);
        area6.addNode("cafe");
        area6.getNode("cafe").data = area1.newData(4, 3);
        area6.addNode("road");
        area6.getNode("road").data = area1.newData(0, 0);
        area6.addNode("butcherShop");
        area6.getNode("butcherShop").data = area1.newData(5, 1);
        area6.addNode("hospital");
        area6.getNode("hospital").data = area1.newData(5, 2);

        area6.addEdge("bridge", "convenienceStore");
        area6.addEdge("convenienceStore", "gasStation");
        area6.addEdge("gasStation", "pharmacy");
        area6.addEdge("pharmacy", "highSchool");
        area6.addEdge("pharmacy", "cafe");
        area6.addEdge("cafe", "road");
        area6.addEdge("road", "butcherShop");
        area6.addEdge("butcherShop", "hospital");

        System.out.println(area6.getAdjList("pharmacy"));
    }
}
