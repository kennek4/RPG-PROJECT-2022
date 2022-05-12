package stuff2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapGraph {

    // Adjacency List
    private Map<MapNode, List<MapNode>> adjNodes;

    public MapGraph() {
        this.adjNodes = new HashMap<MapNode, List<MapNode>>();
    }

    /**
     * Method to add nodes to the map graph
     *
     * @param nodeName the name of the node
     */
    public void addNode(String nodeName) {
        adjNodes.putIfAbsent(new MapNode(nodeName), new ArrayList<MapNode>());
    }

    /**
     * Method to remove node values from the graph
     * 
     * @param nodeName the name of the node
     */
    public void removeNode(String nodeName) {

        MapNode v = new MapNode(nodeName);
        adjNodes.values().stream().forEach(e -> e.remove(v));
        adjNodes.remove(new MapNode(nodeName));

    }

    /**
     * A method to add an edge between two nodes in the graph
     * 
     * @param nodeOneName the name of the first node
     * @param nodeTwoName the name of the second node
     * 
     */
    public void addEdge(String nodeOneName, String nodeTwoName) {

        MapNode nodeOne = new MapNode(nodeOneName);
        MapNode nodeTwo = new MapNode(nodeTwoName);

        adjNodes.get(nodeOne).add(nodeTwo);
        adjNodes.get(nodeTwo).add(nodeOne);
    }

    /**
     * A method to remove the edge between two nodes
     * 
     * @param nodeOneID   the id of the first node
     * @param nodeTwoID   the id of the second node
     * @param nodeOneName the name of the first node
     * @param nodeTwoName the name of the second node
     */
    public void removeEdge(String nodeOneName, String nodeTwoName) {
        MapNode nodeOne = new MapNode(nodeOneName);
        MapNode nodeTwo = new MapNode(nodeTwoName);

        List<MapNode> nodeOneList = adjNodes.get(nodeOne);
        List<MapNode> nodeTwoList = adjNodes.get(nodeTwo);

        if (nodeOneList != null) {
            nodeOneList.remove(nodeTwo);
        }
        if (nodeTwoList != null) {
            nodeTwoList.remove(nodeOne);
        }
    }

    /**
     * A method to retrieve the adjacency list of a node
     * 
     * @param nodeName the name of the node
     * @return the adjacency list of the node
     */
    public List<MapNode> getAdjList(String nodeName) {
        return adjNodes.get(new MapNode(nodeName));
    }

    class MapNode {
        // int id;
        String name;

        public MapNode(String name) {
            // this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MapNode other = (MapNode) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return name;
        }

        private MapGraph getOuterType() {
            return MapGraph.this;
        }
    }
}
