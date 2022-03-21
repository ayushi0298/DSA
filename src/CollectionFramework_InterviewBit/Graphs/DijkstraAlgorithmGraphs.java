package CollectionFramework_InterviewBit.Graphs;

import java.util.*;
//https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/tutorial/
/*
Algorithm:
1)initialize visited with false and distance with MAX value and in priority queue add (source,source distance) initially.
2)while pq is not empty
 a)find min in pq at every iteration
 b) if we find min then update its distance with current distance and weight
 */

//O(ElogV)
public class DijkstraAlgorithmGraphs {
    ArrayList<ArrayList<Pair>> graph;
    boolean visited[];
    int distance[];
    int vertices;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static class Pair implements Comparable<Pair> {
        int value1;
        int value2;

        public Pair(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public int compareTo(Pair o) {
            // min
            return Integer.compare(value2, o.value2);
            // max
//             return Integer.compare(o.value2,value2);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "value1=" + value1 +
                    ", value2=" + value2 +
                    '}';
        }
    }

    //for adjacency list representation
    public void graphCreation(int vertices) {
        this.vertices = vertices;
        graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
       /* pairs= new ArrayList<>(vertices);
          Edge edge = new Edge(source, destination, weight);
          pairs.add(edge);*/
        graph.get(source).add(new Pair(destination, weight));
    }

    //api for dijkstra algorithm.
    public void dijkstra(int source) {
        distance = new int[vertices];
        visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        Pair sourcePair = new Pair(source, distance[source]);
        pq.add(sourcePair);
        while (!pq.isEmpty()) {
            Pair minCurrentNode = pq.poll();
            int vertex = minCurrentNode.value1;
            if (visited[vertex] == false) {
                visited[vertex] = true;
                ArrayList<Pair> adjacentNodes = graph.get(vertex);
                for (int i = 0; i < adjacentNodes.size(); i++) {
                    Pair adjacentNode = adjacentNodes.get(i);
                    int verticeNumber = adjacentNode.value1;
                    if (visited[verticeNumber] == false) {
                        int newWeight = distance[vertex] + adjacentNode.value2;
                        int current = distance[verticeNumber];
                        if (current > newWeight) {
                            Pair p = new Pair(verticeNumber, newWeight);
                            pq.add(p);
                            distance[verticeNumber] = newWeight;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }

    public void printGraph() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(Arrays.toString(new ArrayList[]{graph.get(i)}));
        }
    }

    public static void main(String args[]) {
        DijkstraAlgorithmGraphs da = new DijkstraAlgorithmGraphs();
        da.graphCreation(4);
        da.addEdge(0, 1, 1);
        da.addEdge(0, 3, 3);
        da.addEdge(0, 2, 10);
        da.addEdge(2, 3, 2);
        da.addEdge(1, 2, 4);
        da.printGraph();
        da.dijkstra(0);


//        just to check min and max priority queue for pair
//        pq.add(new Pair(2,3));
//        pq.add(new Pair(2,4));
//        System.out.println(pq.peek());

    }
}
