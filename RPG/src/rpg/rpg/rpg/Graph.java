package rpg;

import java.util.ArrayList;
import java.util.List;

// Graph class
class Graph {
    // node of adjacency list
    static class Node {
        enum AreaType {
            HOUSE,
            ROAD,
            LARGER_ROAD,
            LARGER_HOUSE;
        }

        int value;
        int id;
        Place place;
        String placeName;

        Node(Place place, int id, String placeName) {
            this.place = place;
            this.id = id;
            this.placeName = placeName;
        }
    };

    // define adjacency list

    List<List<Node>> adj_list = new ArrayList<>();

    // Graph Constructor
    public Graph(List<Edge> edges) {
        // adjacency list memory allocation
        for (int i = 0; i < edges.size(); i++)
            adj_list.add(i, new ArrayList<>());

        // add edges to the graph
        for (Edge e : edges) {
            // allocate new node in adjacency List from src to dest
            adj_list.get(e.src).add(new Node(e.place, e.dest, e.srcName));
        }
    }

    // print adjacency list for the graph
    public static void printGraph(Graph graph) {
        int src_vertex = 0;
        int list_size = graph.adj_list.size();

        System.out.println("The contents of the graph:");
        while (src_vertex < list_size) {
            // traverse through the adjacency list and print the edges
            for (Node edge : graph.adj_list.get(src_vertex)) {
                System.out.print("Vertex:" + src_vertex + " ==> " + edge.id +
                        " " + " \t");
            }

            System.out.println();
            src_vertex++;
        }
    }
}