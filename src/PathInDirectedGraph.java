import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/path-in-directed-graph/
public class PathInDirectedGraph {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int vertices, current;

    public void graphCreation(int vertices) {
        this.vertices = vertices;
        graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdges(int x, int y) {
        graph.get(x).add(y);
    }

    public static void pathDirected(int source, ArrayList<ArrayList<Integer>> graph, boolean visited[]) {
        ArrayList<Integer> adjacentNodes = graph.get(source);
        visited[source] = true;
        for (int i = 0; i < adjacentNodes.size(); i++) {
            current = adjacentNodes.get(i);
            if (!visited[current]) {
                visited[current] = true;
                pathDirected(current, graph, visited);
            }
        }
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        vertices = A;
        graphCreation(vertices + 1);
        for (int i = 0; i < B.size(); i++) {
            addEdges(B.get(i).get(0), B.get(i).get(1));
        }
        boolean visited[] = new boolean[vertices + 1];
        int source = 1;
        for (int i = 1; i <= vertices; i++) {
            visited[i] = false;
        }
        pathDirected(source, graph, visited);
        if (visited[A]) {
            return 1;
        }
        return 0;
    }

    public static void main(String args[]) {
        PathInDirectedGraph pd = new PathInDirectedGraph();
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1, 2)));
        System.out.println(pd.solve(2, input));


    }
}
