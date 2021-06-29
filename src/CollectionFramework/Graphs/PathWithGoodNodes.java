package CollectionFramework.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/path-with-good-nodes/
public class PathWithGoodNodes {
    ArrayList<ArrayList<Integer>> graph;
    int vertices, resultCount;

    public void graphCreation(int vertices) {
        this.vertices = vertices;
        graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void printGraph() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(Arrays.toString(new ArrayList[]{graph.get(i)}));
        }
    }

    public void addEdges(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public void     findPaths(int source, ArrayList<Integer> input, int C, int count, boolean visited[]) {
        int current;
        if (input.get(source - 1) == 1) {
            count++;
        }
        ArrayList<Integer> adjacentNodes = graph.get(source);
        if (adjacentNodes.size() == 1 && count <= C) {
            resultCount++;
        }
        for (int i = 0; i < adjacentNodes.size(); i++) {
            current = adjacentNodes.get(i);
            if (!visited[current]) {
                visited[current] = true;
                findPaths(current, input, C, count, visited);
            }
        }
    }

    public int solve(ArrayList<Integer> input, ArrayList<ArrayList<Integer>> listOfEdges, int C) {
        int count = 0;
        vertices = input.size();
        graphCreation(vertices + 1);
        for (int i = 0; i < listOfEdges.size(); i++) {
            addEdges(listOfEdges.get(i).get(0), listOfEdges.get(i).get(1));
        }
        boolean visited[] = new boolean[vertices + 1];
        int source = 1;
        for (int i = 1; i <= vertices; i++) {
            visited[i] = false;
        }
        visited[source]= true;
        findPaths(source, input, C, count, visited);
        return resultCount;
    }

    public static void main(String args[]) {
        PathWithGoodNodes pg = new PathWithGoodNodes();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(-1);
        input.add(1);
        input.add(1);
        input.add(0);
        input.add(0);
        input.add(1);
        input.add(0);
        input.add(0);
        input.add(0);
        input.add(0);
        input.add(0);
        input.add(1);
        input.add(1);
        input.add(1);
        ArrayList<ArrayList<Integer>> listOfEdges = new ArrayList<>();
        listOfEdges.add(0, new ArrayList<>(Arrays.asList(10, 6)));
        listOfEdges.add(1, new ArrayList<>(Arrays.asList(3, 2)));
        listOfEdges.add(2, new ArrayList<>(Arrays.asList(12, 7)));
        listOfEdges.add(3, new ArrayList<>(Arrays.asList(9, 5)));
        listOfEdges.add(4, new ArrayList<>(Arrays.asList(2, 1)));
        listOfEdges.add(5, new ArrayList<>(Arrays.asList(8, 3)));
        listOfEdges.add(6, new ArrayList<>(Arrays.asList(7, 1)));
        listOfEdges.add(7, new ArrayList<>(Arrays.asList(4, 2)));
        listOfEdges.add(8, new ArrayList<>(Arrays.asList(6, 3)));
        listOfEdges.add(9, new ArrayList<>(Arrays.asList(11, 4)));
        listOfEdges.add(10, new ArrayList<>(Arrays.asList(5, 3)));
        listOfEdges.add(11, new ArrayList<>(Arrays.asList(13, 11)));

        int C = 7;
        System.out.println(pg.solve(input, listOfEdges, C));

    }
}
