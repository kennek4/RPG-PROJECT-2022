
import java.util.Scanner;

public class MapDriver {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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

        while (true) {
            System.out.println("Where do you want to go?");
            System.out.println(map.getAdjList(currentPos));
            String choice = sc.next();
            currentPos = choice;
        }
    }
}
