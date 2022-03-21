package Interview.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1
public class PairsEqualToSum {
    int countPairs = 0;

    public int findPairs(ArrayList<Integer> input, int sum) {
        HashMap<Integer, Integer> storesCount = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            if (!storesCount.containsKey(input.get(i))) {
                storesCount.put(input.get(i), 0);
            }
            storesCount.put(input.get(i), storesCount.get(input.get(i)) + 1);
        }
        //System.out.println(storesCount);
        for (int i = 0; i < input.size(); i++) {
            if (storesCount.get(sum - input.get(i)) > 0) {
                countPairs++;
            }
            if (sum - input.get(i) == input.get(i)) {
                countPairs--;
            }
            //System.out.println(countPairs);
        }
        return countPairs;
    }

    public static void main(String args[]) {
        PairsEqualToSum pq = new PairsEqualToSum();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(5);
        input.add(7);
        input.add(-1);
        input.add(5);
        int sum = 6;
        System.out.println(pq.findPairs(input, sum));
    }

}


