package Sept25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Node implements Comparable<Node> {
    public int vertex;
    public int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class Graph {
    private int numberVertices;
    private List<List<Node>> adjlist;

    public Graph(int numberVertices) {
        this.numberVertices = numberVertices;
        adjlist = new ArrayList<>(numberVertices);
        for (int i = 0; i < numberVertices; i++) {
            adjlist.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int des, int wei) {
        adjlist.get(src).add(new Node(des, wei));
        adjlist.get(des).add(new Node(src, wei)); // undirected
    }

    public int[] dijktrasAlgo(int start) {
        int[] disArray = new int[numberVertices];
        Arrays.fill(disArray, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        disArray[start] = 0;
        pq.add(new Node(start, 0));
        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            int curVer = pq.poll().vertex;
            if (visited.contains(curVer)) {
                continue;
            }
            visited.add(curVer);
            for (Node nei : adjlist.get(curVer)) {
                int neiVer = nei.vertex;
                int edgeWei = nei.weight;

                if (disArray[curVer] != Integer.MAX_VALUE && disArray[curVer] + edgeWei < disArray[neiVer]) {
                    disArray[neiVer] = disArray[curVer] + edgeWei;
                    pq.add(new Node(neiVer, disArray[neiVer]));
                }
            }
        }
        return disArray;
    }
}

public class DijktrasAlgo {
    public static void main(String[] args) {
        int numVertices = 6;
        Graph graph = new Graph(numVertices);

        // Define the edges and weights of the graph
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 10);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 4);
        graph.addEdge(4, 5, 2);
        graph.addEdge(3, 5, 6);

        int startVertex = 0;
        int[] shortestDistances = graph.dijktrasAlgo(startVertex);

        System.out.println("Shortest distances from vertex " + startVertex + ":");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("Vertex " + i + ": " + shortestDistances[i]);
        }
    }
}
