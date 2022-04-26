package rpg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class Main{

	public static void main (String[] args) {
		int count =0;
		Scanner in = new Scanner(System.in);
        // define edges of the graph 
        MapList firstMap = new MapList();
        firstMap.edges = Arrays.asList(new Edge(0, 1, new Place("Home")), new Edge(0,2, new Place("Street")), new Edge(0,3, new Place("Street")),
        		new Edge(1,2, new Place("House")), new Edge(1,0, new Place("Ken")),
        		new Edge(2,0, new Place("Kens Mom")), new Edge(2,1, new Place("Kens Dada")), 
        		new Edge(3,0, new Place("Kens Dada")), new Edge(3,2, new Place("Kens Dada")));
        
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
	        int count = 1;
	        int list_size = graph.adj_list.size()/2; // each node NEEDS A CONNECTION in order to print
	 
	        ArrayList<Integer> options = new ArrayList<Integer>();
	        while (true)
	        {
	        System.out.print("You are at: " + src_vertex);
	        
	            //traverse through the adjacency list and print the edges
	            for (Graph.Node edge : graph.adj_list.get(src_vertex)) {
	            	options.add(edge.id);	               
	                                
	            }
	            System.out.print(" Your movement options are: " + options);
	            System.out.print("\nWhere do you want to move?");
	            int move = in.nextInt(); 
	            src_vertex = move;
	            System.out.println();
	           
	            options.clear();
	            
	        }
	

	 }	
}
