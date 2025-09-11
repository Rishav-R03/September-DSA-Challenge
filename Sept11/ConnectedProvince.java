
/**
 * Given a list of cities and the connections between them, count the number of
 * separate groups of cities. This requires you to build the graph and then
 * traverse it to find all connected components.
 */
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class ConnectedProvince {
    private Map<Integer, List<Integer>> adjlist;

    public ConnectedProvince() {
        adjlist = new HashMap<>();
    }

    public void addNode(int node) {
        adjlist.putIfAbsent(node, new LinkedList<>());
    }

    public void addEdge(int u, int v) {
        adjlist.putIfAbsent(u, new LinkedList<>());
        adjlist.putIfAbsent(v, new LinkedList<>());

        adjlist.get(u).add(v);
        adjlist.get(v).add(u);
    }

    public void displayGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjlist.entrySet()) {
            System.out.println("Node " + entry.getKey() + " is connected to: ");
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        ConnectedProvince cp = new ConnectedProvince();

        cp.addEdge(0, 1);
        cp.addEdge(0, 4);
        cp.addEdge(1, 2);
        cp.addEdge(1, 3);
        cp.addEdge(1, 4);
        cp.displayGraph();
    }
}