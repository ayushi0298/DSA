//TC: N*M
//SC: N*M
public class SolitareGameKarat {
    int counts = 0;
    final int dx[] = {0, 0, -1, 1};
    final int dy[] = {-1, 1, 0, 0};

    public int dfs(int[][] grid, int row, int column, int[][] visited) {
        for (int i = 0; i < 4; i++) {
            int x1 = row + dx[i];
            int y1 = column + dy[i];
             //System.out.println(" before x1 " + x1 + " y1 " + y1 + " "  + grid.length);
            if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 <= grid.length && grid[row][column] == grid[x1][y1] && visited[x1][y1] == -1) {
                //System.out.println(" x1 " + x1 + " y1 " + y1);
                visited[x1][y1] = 1;
                counts++;
                //System.out.println(counts);
                dfs(grid, x1, y1, visited);
            }
        }
        return counts;
    }

    public int countDisappears(int[][] grid, int row, int column) {
       //System.out.println("ROWS : " + grid.length + "COLUMNS : " + grid[0].length);
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[row].length; j++) {
                visited[i][j] = -1;
            }
        }
        visited[row][column] = 1;
        counts++;
        int count = dfs(grid, row, column, visited);
        if (count != 0) {
            return count;
        }

        return 0;
    }

    public static void main(String args[]) {
        SolitareGameKarat sg = new SolitareGameKarat();
        int[][] grid1 = {{0, 3, 3, 3, 3, 3, 3},
                {0, 1, 1, 1, 1, 1, 3},
                {0, 2, 2, 0, 2, 1, 4},
                {0, 1, 2, 2, 2, 1, 3},
                {0, 1, 1, 1, 1, 1, 3},
                {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] grid3 = {{4, 4, 4, 4},
                {5, 5, 5, 4},
                {2, 5, 7, 5},
        };
        int[][] grid2 = {{1, 1},
                {0, 1}
        };
        System.out.println(sg.countDisappears(grid1, 1,1));
    }


}
