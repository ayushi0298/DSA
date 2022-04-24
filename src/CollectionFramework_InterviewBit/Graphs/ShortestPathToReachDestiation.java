package CollectionFramework_InterviewBit.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class ShortestPathToReachDestiation {
    final int inf = (int) (1e9 + 1);
    final int dx[] = {0, 0, -1, 1};
    final int dy[] = {-1, 1, 0, 0};

    public int findShortest(int[][] input) {
        int dist[][] = new int[input.length + 1][input.length + 1];
        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= input.length; j++) {
                dist[i][j] = inf;
                dist[1][1] = 1;
            }
        }
       // int source = input[0][0];
        Queue<int[]> storeRooms = new LinkedList<>();
        storeRooms.add(new int[]{0,0});
        while (!storeRooms.isEmpty()) {
            int[] v = storeRooms.remove();
            for (int i = 0; i < 4; i++) {
                int x1 = v[0] + dx[i];
                int y1 = v[1] + dy[i];
                if (x1 >= 1 && x1 <= input.length && y1 >= 1 && y1 <= input.length && input[v[0]][v[1]] != input[x1][y1] && dist[x1][y1] > dist[v[0]][v[1]] + 1) {
                    dist[x1][y1] = dist[v[0]][v[1]] + 1;
                    storeRooms.add(new int[]{x1, y1});
                }
            }
        }
        System.out.println(storeRooms);
        return dist[input.length][input.length] == inf ? -1 : dist[input.length][input.length];
    }

    public static void main(String args[]) {
        ShortestPathToReachDestiation st = new ShortestPathToReachDestiation();
        int[][] grid1 = {{0, 1}, {0, 0}};
        System.out.println(st.findShortest(grid1));

    }
}