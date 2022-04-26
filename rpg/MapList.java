package rpg;
import java.util.ArrayList;
import java.util.List;

public class MapList {
	static enum MapType {
		HOUSE,
		ROAD,
		LARGE_BUILDING;
	}
	public List<Edge> edges;
	public MapList() {
		// whole map area
		edges = new ArrayList<>();
	}
}

