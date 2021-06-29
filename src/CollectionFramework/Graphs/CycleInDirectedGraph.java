package CollectionFramework.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/cycle-in-directed-graph/
public class CycleInDirectedGraph {
    public void printGraph() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(Arrays.toString(new ArrayList[]{graph.get(i)}));
        }
    }

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
    }

    public boolean isCycle(int source, boolean[] visited, boolean[] recStack) {


        if (recStack[source]) {
            return true;
        }
        if (visited[source]) {
            return false;
        }

        visited[source] = true;
        recStack[source] = true;
        ArrayList<Integer> adjacentNodes = graph.get(source);
        for (Integer i : adjacentNodes) {
            if (isCycle(i, visited, recStack)) {
                return true;
            }
        }
        recStack[source] = false;
        return false;

    }

    public int  solve(int A, ArrayList<ArrayList<Integer>> B) {
        vertices = A;
        graphCreation(vertices + 1);

        for (int i = 0; i < B.size(); i++) {
            addEdges(B.get(i).get(0), B.get(i).get(1));
        }
        boolean visited[] = new boolean[vertices + 1];
        boolean recursionStack[] = new boolean[vertices + 1];
        for (int i = 0; i < vertices; i++) {
            if (isCycle(i, visited, recursionStack)) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String args[]) {
        CycleInDirectedGraph cd = new CycleInDirectedGraph();
        int A = 2;
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1, 2)));
        input.add(new ArrayList<>(Arrays.asList(2,1)));
        System.out.println(cd.solve(A, input));


    }
}
