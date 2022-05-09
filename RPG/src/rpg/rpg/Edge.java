package rpg;

//class to store edges of the weighted graph
class Edge {
    int src, dest;
    Place place;

    Edge(int src, int dest, Place place) {
        this.src = src;
        this.dest = dest;
        this.place = place;

    }
}