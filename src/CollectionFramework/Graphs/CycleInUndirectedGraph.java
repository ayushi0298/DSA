package CollectionFramework.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//https://www.interviewbit.com/problems/cycle-in-undirected-graph/
public class CycleInUndirectedGraph {
    ArrayList<ArrayList<Integer>> graph;
    int vertices;

    public void graphCreation(int vertices) {
        this.vertices = vertices;
        graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdges(int x, int y) {
        graph.get(y).add(x);
        graph.get(x).add(y);

    }

    public boolean isCycle(int source, boolean[] visited, int parent) {
        visited[source] = true;
        Iterator<Integer> it = graph.get(source).iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (!visited[i]) {
                if (isCycle(i, visited, source))
                    return true;
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        vertices = A;
        graphCreation(vertices + 1);
        boolean visited[] = new boolean[vertices + 1];
        for (int i = 0; i < B.size(); i++) {
            addEdges(B.get(i).get(0), B.get(i).get(1));
        }
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
        }
        for (int u = 0; u < vertices; u++) {
            if (!visited[u]) {
                if (isCycle(u, visited, -1)) {
                    return 1;
                }
            }
        }
        return 0;
    }


    public static void main(String args[]) {
        CycleInUndirectedGraph cd = new CycleInUndirectedGraph();
        int A = 2;
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1, 2)));
        System.out.println(cd.solve(A, input));


    }

}
