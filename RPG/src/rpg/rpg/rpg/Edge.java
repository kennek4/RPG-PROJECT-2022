package rpg;

//class to store edges of the weighted graph
class Edge {
    int src, dest;
    String srcName, destName;
    Place place;

    Edge(int src, int dest, String srcName, String destName) {
        this.src = src;
        this.dest = dest;
        this.srcName = srcName;
        this.destName = destName;
        // this.place = place;
    }
}