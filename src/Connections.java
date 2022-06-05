import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://stackoverflow.com/questions/52652675/counting-connections-in-a-mn-matrix

public class Connections {
    private boolean canVisit(int i, int j, int rows, int columns, boolean[][] visited) {
        return i < rows && j < columns && i >= 0 && j >= 0 && !visited[i][j];
    }

    public int countConnections(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        final int[] x = {1, 1, 1, -1, -1, -1, 0, 0};
        final int[] y = {1, -1, 0, 1, -1, 0, 1, -1};
        int count = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < 8; k++) {
                    int l = i + x[k];
                    int m = j + y[k];
                    //check for connections only if the given cell has value 1
                    if (matrix[i][j] == 1 && canVisit(l, m, rows, columns, visited) && matrix[l][m] == 1) {
                        count++;
                    }

                }
                visited[i][j] = true;
            }
        }
        return count;


    }

    public int hehe(List<List<Integer>> matrix) {
        int[][] arr = matrix.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        int results = countConnections(arr);
        return results;
    }


    public static void main(String args[]) {
        Connections c = new Connections();
        int[][] grid4 = {{1, 0, 1},
                {1, 0, 1},
                {1, 1, 1},

        };
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 0, 1));
        matrix.add(Arrays.asList(1, 0, 1));
        matrix.add(Arrays.asList(1, 1, 1));

        System.out.println(c.hehe(matrix));

    }
}
