package CollectionFramework.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//https://www.interviewbit.com/problems/highest-product/
public class HighestProductGreedy {
    int product = 1, n = 0, x, y;

    public int findProduct(ArrayList<Integer> input) {
        int size = input.size() - 1;
        if (input.size() < 3) {
            return -1;
        } else {
            Collections.sort(input);
            System.out.println(input + " " + n);
            x = input.get(0) * input.get(1) * input.get(size);
            y = input.get(size) * input.get(size - 1) * input.get(size - 2);
        }
        return Math.max(x, y);
    }
    public static void main(String args[]) {
        HighestProductGreedy hp = new HighestProductGreedy();
        ArrayList<Integer> input = new ArrayList<Integer>(
                Arrays.asList(0, -1, 3, 100, -70, -50));
        /*ArrayList<Integer> input = new ArrayList<>();
        input.add(10);
        input.add(3);
        input.add(9);
        input.add(20);*/
        System.out.println(hp.findProduct(input));

    }
}
