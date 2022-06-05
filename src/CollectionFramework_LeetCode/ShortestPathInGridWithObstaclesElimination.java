package CollectionFramework_LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
public class ShortestPathInGridWithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<int[]> queue = new ArrayDeque<int[]>();
        boolean[][][] visited = new boolean[n][m][k + 1];
        queue.offer(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int row = current[0], column = current[1], ks = current[2], steps = current[3];
            if (row == n - 1 && column == m - 1) {
                return steps;
            }
            visited[row][column][ks] = true;
            for (int[] dir : directions) {
                int r1 = row + dir[0], c1 = column + dir[1];

                if (r1 < 0 || r1 >= n || c1 < 0 || c1 >= m) {
                    continue;
                }
                if (grid[r1][c1] == 0 && !visited[r1][c1][ks]) {
                    queue.addLast(new int[]{r1, c1, ks, steps + 1});
                    continue;
                }

                if (ks < k && !visited[r1][c1][ks + 1]) {
                    queue.addLast(new int[]{r1, c1, ks + 1, steps + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        ShortestPathInGridWithObstaclesElimination sp = new ShortestPathInGridWithObstaclesElimination();
        int[][] grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        int k = 1;
        System.out.println(sp.shortestPath(grid, k));
    }
}
