package Interview.TreeMap;

import CollectionFramework_InterviewBit.Graphs.DijkstraAlgorithmGraphs;
import CollectionFramework_InterviewBit.Stream;

import java.util.*;

public class KClosestPointToOrigin {

    int count=0;
    private ArrayList<int[]> findKPoints(int[][] input, int k) {
        ArrayList<int[]> output = new ArrayList<>();
        TreeMap<Integer, int[]> storesDistances = new TreeMap();
        for (int i = 0; i < input.length; i++) {

            int distance = (input[i][0] * input[i][0]) + (input[i][1] * input[i][1]);

            System.out.println("d: " + distance + " " + input[i][0] + " " + input[i][1]);

            storesDistances.put(distance, new int[]{input[i][0], input[i][1]});
        }
        for (Integer key : storesDistances.keySet()) {
            if (count < k) {
               // System.out.println("key: " + key + "x: " + storesDistances.get(key)[0] + " y: " + storesDistances.get(key)[1]);
                output.add((storesDistances.get(key)));
                count++;
            }
        }
        return output;

    }
    public static void main(String args[]) {
        KClosestPointToOrigin kc = new KClosestPointToOrigin();
        int[][] input = {{1, 2}, {2, 2}, {3, 2}, {1, 5}};
        int k = 2;
        System.out.println(kc.findKPoints(input, k));


    }


}
