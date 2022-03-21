package CollectionFramework_InterviewBit.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class RegionInBinaryMatrix {
    int rows, columns,count;

    public boolean isSafe(ArrayList<ArrayList<Integer>> graph,int Rows, int Columns, boolean[][] visited) {
     return ((Rows>=0) && (Rows<rows) &&(Columns>=0) && (Columns<columns)&& (graph.get(rows).get(columns)==1)&& !visited[Rows][Columns]);
    }

    public void largestRegion(ArrayList<ArrayList<Integer>> graph, int Rows, int Columns, boolean[][] visited) {
        int[] rowPresent = {1, -1, 0, 0,1,-1,-1,1};
        int[] columnPresent = {0, 0, 1, -1,1,-1,1,-1};
       // System.out.println(Rows+ " " + Columns);
        visited[Rows][Columns] = true;
        //System.out.println(Arrays.deepToString(visited));
        for (int k = 0; k < 8; k++) {
            if (isSafe(graph, Rows + rowPresent[k], Columns + columnPresent[k] , visited)) {
                count++;
                largestRegion(graph, Rows + rowPresent[k], Columns + columnPresent[k], visited);
            }
        }

    }


    public int solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int columns = A.get(0).size();
        //System.out.println(rows+ " " +columns);
        boolean[][] visited = new boolean[rows][columns];
        //System.out.println(Arrays.deepToString(visited));
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (A.get(i).get(j) == 1 && !visited[i][j]) {
                    count=count+1;
                    largestRegion(A, i, j, visited);
                    result = Math.max(count, result);
                    System.out.println(count + " " + result);
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        RegionInBinaryMatrix rb = new RegionInBinaryMatrix();
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 0, 0, 1)));
        input.add(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 0, 1, 0)));
        input.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1, 0, 1)));
        input.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 0, 1, 1)));
        input.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 0, 1, 1)));
        input.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0, 0, 1)));
        input.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0)));
        input.add(new ArrayList<>(Arrays.asList(0, 0, 1, 0, 1, 0, 0)));
        System.out.println(rb.solve(input));


    }
}
