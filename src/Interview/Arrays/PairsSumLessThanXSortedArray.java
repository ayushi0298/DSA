package Interview.Arrays;

import java.util.Arrays;
//https://www.geeksforgeeks.org/count-pairs-array-whose-sum-less-x/
public class PairsSumLessThanXSortedArray {
    public int countPairs(int[] input, int k) {
        Arrays.sort(input);
        int left = 0, right = input.length - 1;
        int result = 0;

        while (left < right) {
            if (input[left] + input[right] < k) {
                result += (right - left);
                left++;
            } else
                right--;
        }

        return result;
    }


    public static void main(String args[]) {
        PairsSumLessThanXSortedArray px = new PairsSumLessThanXSortedArray();
        int[] input = new int[]{1, 2, 3, 4, 5, 8, 7, 6};
        int k = 7;
        System.out.println(px.countPairs(input, k));


    }
}
