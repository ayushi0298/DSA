package CollectionFramework_InterviewBit.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {
    ArrayList<ArrayList<Integer>> graph;
    int vertices, current;

    public void graphCreation(int vertices) {
        this.vertices = vertices;
        graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdges(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public void callingBFS(int source, boolean visited[]) {
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        while (!queue.isEmpty()) {
            source = queue.poll();
            System.out.println(source);
            ArrayList<Integer> storesAdjacent = graph.get(source);
            for (int i = 0; i < storesAdjacent.size(); i++) {
                current = storesAdjacent.get(i);
                if (!visited[current]) {
                    visited[current] = true;
                    queue.add(current);
                }
            }
        }
    }

    public void BFS(int source) {
        boolean visited[] = new boolean[vertices];
        callingBFS(source, visited);

    }

    public static void main(String args[]) {
        BreathFirstSearch graph = new BreathFirstSearch();
        graph.graphCreation(8);
        graph.addEdges(1, 2);
        graph.addEdges(1, 3);
        graph.addEdges(2, 4);
        graph.addEdges(2, 5);
        graph.addEdges(3, 6);
        graph.addEdges(3, 7);
        graph.BFS(4);

    }

}
