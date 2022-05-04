package rpg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;




public class Main implements KeyListener {

	public static void main (String[] args) {
		int count =0;
		Scanner in = new Scanner(System.in);
        // define edges of the graph 
        MapList firstMap = new MapList();
        firstMap.edges = Arrays.asList(new Edge(0, 1, new Place("Park")),
        		new Edge(1, 0, new Place("Hospital")),new Edge(1, 2, new Place("Hospital")),
        		new Edge(2, 1, new Place("Road")) ,new Edge(2, 3, new Place("Road")),
        		new Edge(3, 2, new Place("Fire Station")),new Edge(3, 4, new Place("Fire Station")),
        		new Edge(4, 3, new Place("Road")),new Edge(4, 5, new Place("Road")), new Edge(4, 8, new Place("Road")),       		
        		new Edge(5, 6, new Place("Warehouse")),
        		new Edge(6, 7, new Place("Jewellery Store")),
        		new Edge(7, 11, new Place("Factory")),
        		new Edge(8, 9, new Place("Road")),
        		new Edge(9, 10, new Place("Lumber Store")),
        		new Edge(10, 11, new Place("Road")));
        
        // call graph class Constructor to construct a graph
        Graph graph = new Graph(firstMap.edges);
        // print the graph as an adjacency list
        
        
       
       Graph.printGraph(graph);
       printOptions(graph);
       while (true)
       {
       System.out.println( graph.adj_list.get(count).get(count).place.getPlace());
       System.out.println("Next?");
       String next = in.next();
       if(next.equalsIgnoreCase("Next"))
       {
       	count++;
       }
       }
    }
	 public static void printOptions(Graph graph)  {
		 Scanner in = new Scanner(System.in);
	        int src_vertex = 0;
	        int count = 0;
	        int choice = 0;
	 
	        HashMap<Integer,Graph.Node> options = new HashMap<>();
	        while (true)
	        {
	        System.out.print("You are at: " + src_vertex +" "+ graph.adj_list.get(src_vertex).get(choice).place.getPlace());
	        
	            //traverse through the adjacency list and print the edges
	          	for(int i = 0; i<graph.adj_list.get(src_vertex).size(); i++ )
	          	{
	          		options.put(i+1, graph.adj_list.get(src_vertex).get(i));
	          	}
	          		
	            System.out.print(" Your movement options are: " + options);
	            System.out.print("\nWhere do you want to move?");
	            choice = in.nextInt(); 
	            src_vertex = graph.adj_list.get(choice).get(choice).id;
	            System.out.println();
	           
	            options.clear();
	            
	        }
	

	 }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		if (key == KeyEvent.VK_1) {
			
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
