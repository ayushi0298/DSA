package Interview.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        int count = 0, result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            int current = queue.peek();
            count++;
            queue.remove();
            if (count == k) {
                result = current;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        KthLargestElement kt = new KthLargestElement();
        int k = 2;
        int[] input = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(kt.findKthLargest(input, k));
    }
}
