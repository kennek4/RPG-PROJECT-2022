package rpg;

//class to store edges of the weighted graph
class Edge {
    int src, dest;
    Place destPlace,srcPlace;
    Edge(int src, int dest, Place destPlace, Place srcPlace) {
            this.src = src;
            this.dest = dest;
            this.destPlace = destPlace;
            this.srcPlace = srcPlace; 
        }
}