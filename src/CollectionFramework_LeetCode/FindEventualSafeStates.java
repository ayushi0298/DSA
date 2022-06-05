package CollectionFramework_LeetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-eventual-safe-states/
public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> output = new ArrayList<>();
        int[] visitedStates = new int[graph.length];
        for (int i = 0; i < visitedStates.length; i++) {
            if (dfs(graph, visitedStates, i)) {
                output.add(i);
            }
        }
        return output;
    }

    public boolean dfs(int[][] input, int[] visitedStates, int i) {
        if (visitedStates[i] > 0) {
            return visitedStates[i] == 2;
        }
        visitedStates[i] = 1;
        for (int adjacents : input[i]) {
            if (visitedStates[adjacents] == 2) {
                continue;
            }
            if (visitedStates[adjacents] == 1 || !dfs(input, visitedStates, adjacents)) {
                return false;
            }
        }
        visitedStates[i] = 2;
        return true;
    }

    public static void main(String args[]) {
        FindEventualSafeStates fl = new FindEventualSafeStates();
        int input[][] = new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(fl.eventualSafeNodes(input));

    }
}
