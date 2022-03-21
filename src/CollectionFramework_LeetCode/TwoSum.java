package CollectionFramework_LeetCode;

import Interview.Arrays.PairsEqualToSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*https://leetcode.com/problems/two-sum/
 jo "target-input[i]" means final result value h usse hashmap mein daal
 do and jab vo value input array mein aayegi toh else condition mein jaayega and uska index output array mein jaayega*/
public class TwoSum {
    int[] output = new int[2];

    public int[] twoSum(int[] input, int target) {
        HashMap<Integer, Integer> storeInput = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (!storeInput.containsKey(input[i])) {

                storeInput.put(target - input[i], i);

            }
            // ye target - input[i] value h mil gyi input array mein
            else {
                output[0] = i;
                output[1] = storeInput.get(input[i]);
                break;
            }
        }
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
        return output;
    }
    /* for Leet Code
    public int[] twoSum(int[] input, int target) {
        HashMap<Integer, Integer> storeInput = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (!storeInput.containsKey(input[i])) {

                storeInput.put(target - input[i], i);

            }
            // ye target - input[i] value h mil gyi input array mein
            else {
                output[0] = i;
                output[1] = storeInput.get(input[i]);
                break;
            }
        }
        return output;
    }*/

    public static void main(String args[]) {
        TwoSum ts = new TwoSum();
        int target = 30;
        int[] a = new int[3];
        a[0] = 10;
        a[1] = 20;
        a[2] = 70;
        System.out.println(ts.twoSum(a, target));
    }
}
