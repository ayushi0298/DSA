package CollectionFramework_InterviewBit.Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumEdgeRemoval {
    ArrayList<ArrayList<Integer>> graph;
    int vertices, result;

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


    public int callingDFS(int result, boolean visited[]) {
        visited[result] = true;
        int currentNodeNumber = 0;
        for (int i = 0; i < graph.get(result).size(); i++) {
            int current = graph.get(result).get(i);
            if (!visited[current]) {
                int subTreeCount = callingDFS(current, visited);
                if (subTreeCount % 2 == 0)
                    result++;

                else
                    currentNodeNumber += subTreeCount;
            }
        }
        return currentNodeNumber + 1;
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        vertices = A;
        graphCreation(vertices + 1);
        for (int i = 0; i < B.size(); i++) {
            addEdges(B.get(i).get(0), B.get(i).get(1));
        }
        boolean visited[] = new boolean[vertices + 1];
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
        }
        result = 0;
        callingDFS(result, visited);
        return result;
    }

    public static void main(String args[]) {
        MaximumEdgeRemoval me = new MaximumEdgeRemoval();
        int k = 6;
        ArrayList<ArrayList<Integer>> listOfEdges = new ArrayList<>();
        listOfEdges.add(0, new ArrayList<>(Arrays.asList(1, 2)));
        listOfEdges.add(0, new ArrayList<>(Arrays.asList(1, 4)));
        listOfEdges.add(0, new ArrayList<>(Arrays.asList(1, 3)));
        listOfEdges.add(0, new ArrayList<>(Arrays.asList(3, 4)));
        listOfEdges.add(0, new ArrayList<>(Arrays.asList(4, 6)));
        System.out.println(me.solve(k, listOfEdges));


    }
}
