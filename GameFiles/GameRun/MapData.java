package GameRun;

/**
 * The class that holds all necessary information on map nodes
 */
public class MapData {

    MapGraph area1;
    MapGraph area2;
    MapGraph area3;
    MapGraph area4;
    MapGraph area5;
    MapGraph area6;

    /**
     * Creation of all nodes within the game.
     */
    public MapData() {

        area1 = new MapGraph();
        area1.addNode("Park");

        area1.addNode("Hospital");
        area1.getNode("Hospital").data.enemyAmount = 0;
        area1.getNode("Hospital").data.tier = 0;
        area1.getNode("Hospital").data.areaType = "building";

        area1.addNode("Fire Station");
        area1.getNode("Fire Station").data.enemyAmount = 1;
        area1.getNode("Fire Station").data.tier = 2;
        area1.getNode("Fire Station").data.areaType = "building";

        area1.addNode("Dirty Road");
        area1.getNode("Dirty Road").data.enemyAmount = 1;
        area1.getNode("Dirty Road").data.tier = 2;
        area1.getNode("Dirty Road").data.areaType = "road";

        area1.addNode("Split Road");
        area1.getNode("Split Road").data.enemyAmount = 0;
        area1.getNode("Split Road").data.tier = 0;
        area1.getNode("Split Road").data.areaType = "road";

        area1.addNode("Warehouse");
        area1.getNode("Warehouse").data.enemyAmount = 2;
        area1.getNode("Warehouse").data.tier = 1;
        area1.getNode("Warehouse").data.areaType = "building";

        area1.addNode("Cracked Road");
        area1.getNode("Cracked Road").data.enemyAmount = 0;
        area1.getNode("Cracked Road").data.tier = 0;
        area1.getNode("Cracked Road").data.areaType = "road";

        area1.addNode("Jewellery Store");
        area1.getNode("Jewellery Store").data.enemyAmount = 1;
        area1.getNode("Jewellery Store").data.tier = 3;
        area1.getNode("Jewellery Store").data.areaType = "building";

        area1.addNode("Factory");
        area1.getNode("Factory").data.enemyAmount = 1;
        area1.getNode("Factory").data.tier = 4;
        area1.getNode("Factory").data.areaType = "building";

        area1.addNode("Lumber Store");
        area1.getNode("Lumber Store").data.enemyAmount = 2;
        area1.getNode("Lumber Store").data.tier = 2;
        area1.getNode("Lumber Store").data.areaType = "building";

        area1.addNode("Highway");
        area1.getNode("Highway").data.enemyAmount = 1;
        area1.getNode("Highway").data.tier = 4;
        area1.getNode("Highway").data.areaType = "road";

        area1.addNode("Checkpoint");
        area1.getNode("Checkpoint").data.enemyAmount = 1;
        area1.getNode("Checkpoint").data.tier = 5;
        area1.getNode("Checkpoint").data.areaType = "checkpoint";

        area1.addEdge("Park", "Hospital");
        area1.addEdge("Hospital", "Dirty Road");
        area1.addEdge("Dirty Road", "Fire Station");
        area1.addEdge("Fire Station", "Split Road");
        area1.addEdge("Split Road", "Warehouse");
        area1.addEdge("Split Road", "Cracked Road");
        area1.addEdge("Warehouse", "Jewellery Store");
        area1.addEdge("Jewellery Store", "Factory");
        area1.addEdge("Factory", "Checkpoint");
        area1.addEdge("Cracked Road", "Lumber Store");
        area1.addEdge("Lumber Store", "Highway");
        area1.addEdge("Highway", "Checkpoint");

        area2 = new MapGraph();
        area2.addNode("Checkpoint");
        area2.addNode("Highway");
        area2.getNode("Highway").data = area2.newData(2, 1);
        area2.addNode("Car Rental");
        area2.getNode("Car Rental").data = area2.newData(2, 2);
        area2.addNode("Convenience Store");
        area2.getNode("Convenience Store").data = area2.newData(2, 3);
        area2.addNode("Gym");
        area2.getNode("Gym").data = area2.newData(3, 1);
        area2.addNode("Dry Road");
        area2.getNode("Dry Road").data = area2.newData(0, 0);
        area2.addNode("Muddy Road");
        area2.getNode("Muddy Road").data = area2.newData(2, 3);
        area2.addNode("Bus Shelter");
        area2.getNode("Bus Shelter").data = area2.newData(4, 1);
        area2.addNode("Rocky Road");
        area2.getNode("Rocky Road").data = area2.newData(4, 2);
        area2.addNode("Bridge");
        area2.getNode("Bridge").data = area2.newData(5, 1);

        area2.addEdge("Checkpoint", "Highway");
        area2.addEdge("Highway", "Car Rental");
        area2.addEdge("Car Rental", "Convenience Store");
        area2.addEdge("Convenience Store", "Gym");
        area2.addEdge("Gym", "Dry Road");
        area2.addEdge("Dry Road", "Muddy Road");
        area2.addEdge("Muddy Road", "Bus Shelter");
        area2.addEdge("Bus Shelter", "Rocky Road");
        area2.addEdge("Rocky Road", "Bridge");

        area3 = new MapGraph();
        area3.addNode("Bridge");
        area3.getNode("Bridge").data = area3.newData(2, 3);
        area3.addNode("Dirty Road");
        area3.getNode("Dirty Road").data = area3.newData(2, 2);
        area3.addNode("Chicken Shop");
        area3.getNode("Chicken Shop").data = area3.newData(3, 1);
        area3.addNode("Post Office");
        area3.getNode("Post Office").data = area3.newData(3, 2);
        area3.addNode("Motel");
        area3.getNode("Motel").data = area3.newData(0, 0);
        area3.addNode("Large Park");
        area3.getNode("Large Park").data = area3.newData(2, 3);
        area3.addNode("Cafe");
        area3.getNode("Cafe").data = area3.newData(4, 1);
        area3.addNode("Street");
        area3.getNode("Street").data = area3.newData(0, 0);
        area3.addNode("Alley");
        area3.getNode("Alley").data = area3.newData(3, 3);
        area3.addNode("Restaurant");
        area3.getNode("Restaurant").data = area3.newData(4, 2);
        area3.addNode("Cracked Road");
        area3.getNode("Cracked Road").data = area3.newData(3, 3);
        area3.addNode("Long Bridge");
        area3.getNode("Long Bridge").data = area3.newData(5, 1);

        area3.addEdge("Bridge", "Dirty Road");
        area3.addEdge("Dirty Road", "Chicken Shop");
        area3.addEdge("Chicken Shop", "Post Office");
        area3.addEdge("Post Office", "Motel");
        area3.addEdge("Motel", "Large Park");
        area3.addEdge("Large Park", "Cafe");
        area3.addEdge("Cafe", "Street");
        area3.addEdge("Street", "Alley");
        area3.addEdge("Alley", "Restaurant");
        area3.addEdge("Restaurant", "Cracked Road");
        area3.addEdge("Cracked Road", "Long Bridge");

        area4 = new MapGraph();
        area4.addNode("Bridge");
        area4.getNode("Bridge").data = area1.newData(1, 3);
        area4.addNode("Junction");
        area4.getNode("Junction").data = area1.newData(2, 2);
        area4.addNode("Bank");
        area4.getNode("Bank").data = area1.newData(3, 2);
        area4.addNode("Supermarket");
        area4.getNode("Supermarket").data = area1.newData(2, 3);
        area4.addNode("Desolate Road");
        area4.getNode("Desolate Road").data = area1.newData(0, 0);
        area4.addNode("Alley");
        area4.getNode("Alley").data = area1.newData(3, 2);
        area4.addNode("Subway Station");
        area4.getNode("Subway Station").data = area1.newData(4, 1);
        area4.addNode("Gas Station");
        area4.getNode("Gas Station").data = area1.newData(3, 3);
        area4.addNode("Street");
        area4.getNode("Street").data = area1.newData(2, 3);
        area4.addNode("Broken Road");
        area4.getNode("Broken Road").data = area1.newData(0, 0);
        area4.addNode("Mechanic");
        area4.getNode("Mechanic").data = area1.newData(4, 2);
        area4.addNode("Power Station");
        area4.getNode("Power Station").data = area1.newData(5, 1);

        area4.addEdge("Bridge", "Junction");
        area4.addEdge("Junction", "Bank");
        area4.addEdge("Bank", "Supermarket");
        area4.addEdge("Supermarket", "Desolate Road");
        area4.addEdge("Desolate Road", "Alley");
        area4.addEdge("Alley", "Subway Station");
        area4.addEdge("Subway Station", "Gas Station");
        area4.addEdge("Gas Station", "Street");
        area4.addEdge("Street", "Broken Road");
        area4.addEdge("Broken Road", "Mechanic");
        area4.addEdge("Mechanic", "Power Station");

        area5 = new MapGraph();
        area5.addNode("Street");
        area5.getNode("Street").data = area1.newData(1, 3);
        area5.addNode("Elementary School");
        area5.getNode("Elementary School").data = area1.newData(2, 2);
        area5.addNode("Boulevard");
        area5.getNode("Boulevard").data = area1.newData(2, 3);
        area5.addNode("Grocery Store");
        area5.getNode("Grocery Store").data = area1.newData(3, 2);
        area5.addNode("Sport Complex");
        area5.getNode("Sport Complex").data = area1.newData(3, 3);
        area5.addNode("Church");
        area5.getNode("Church").data = area1.newData(0, 0);
        area5.addNode("Alley");
        area5.getNode("Alley").data = area1.newData(4, 2);
        area5.addNode("Cracked Road");
        area5.getNode("Cracked Road").data = area1.newData(2, 3);
        area5.addNode("Beach");
        area5.getNode("Beach").data = area1.newData(4, 3);
        area5.addNode("Park");
        area5.getNode("Park").data = area1.newData(0, 0);
        area5.addNode("Long Road");
        area5.getNode("Long Road").data = area1.newData(4, 2);
        area5.addNode("Bridge");
        area5.getNode("Bridge").data = area1.newData(5, 2);

        area5.addEdge("Street", "Elementary School");
        area5.addEdge("Elementary School", "Boulevard");
        area5.addEdge("Boulevard", "Grocery Store");
        area5.addEdge("Grocery Store", "Sport Complex");
        area5.addEdge("Sport Complex", "Church");
        area5.addEdge("Church", "Alley");
        area5.addEdge("Alley", "Cracked Road");
        area5.addEdge("Cracked Road", "Beach");
        area5.addEdge("Beach", "Park");
        area5.addEdge("Park", "Long Road");
        area5.addEdge("Long Road", "Bridge");

        area6 = new MapGraph();
        area6.addNode("bridge");
        area6.getNode("bridge").data = area1.newData(1, 3);
        area6.addNode("Convenience Store");
        area6.getNode("Convenience Store").data = area1.newData(2, 2);
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

        area6.addEdge("bridge", "Convenience Store");
        area6.addEdge("Convenience Store", "gasStation");
        area6.addEdge("gasStation", "pharmacy");
        area6.addEdge("pharmacy", "highSchool");
        area6.addEdge("pharmacy", "cafe");
        area6.addEdge("cafe", "road");
        area6.addEdge("road", "butcherShop");
        area6.addEdge("butcherShop", "hospital");

    }
}
