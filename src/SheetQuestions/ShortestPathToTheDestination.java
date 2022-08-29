package SheetQuestions;

import java.util.*;

//https://www.lintcode.com/problem/1563/
public class ShortestPathToTheDestination {
    int counts = 1;
    final int dx[] = {0, 0, -1, 1};
    final int dy[] = {-1, 1, 0, 0};

    private boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public int shortestPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        int level = bfsWithLevel(0, 0, grid, m, n, visited);

        return level;
    }

    public int bfsWithLevel(int i, int j, int[][] grid, int m, int n, boolean[][] visited) {
        Queue<int[]> storesCoordinates = new ArrayDeque<>();
        storesCoordinates.add(new int[]{i, j});
        visited[0][0] = true;
        while (!storesCoordinates.isEmpty()) {
            int size = storesCoordinates.size();
            while (size-- > 0) {
                int[] current = storesCoordinates.poll();
                for (int k = 0; k < 4; k++) {
                    int x = current[0] + dx[k];
                    int y = current[1] + dy[k];
                    /*if (!isValid(x, y, m, n) || grid[x][y] == 1) {
                        continue;
                    }
                    if (grid[x][y] == 2) {
                        return counts;
                    }*/
                    if (isValid(x, y, m, n) && visited[x][y] == false && grid[x][y] == 1) {
                        //System.out.println("K + " + "x : " + x + "y : " + y);
                        storesCoordinates.add(new int[]{x, y});
                        visited[x][y] = true;
                        counts++;
                    }
                }
            }
        }
        if (counts >= 1) {
            return counts;
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {
        ShortestPathToTheDestination sg = new ShortestPathToTheDestination();
        int[][] grid1 = {{0, 0, 0},
                {0, 0, 1},
                {0, 0, 2},
        };
        int[][] grid2 = {{0, 1},
                {0, 1},
                {0, 0},
                {0, 2},
        };
        int[][] grid3 = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };
        System.out.println(sg.shortestPath(grid3));
    }
}
//1,0,1
