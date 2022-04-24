package FinalTouch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/3sum/
public class ThreeSumZero {
    int count = 0;

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;// Skip equal elements to avoid duplicates
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {// Two Pointers
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left + 1 < right && nums[left] == nums[left + 1])// Skip equal elements to avoid duplicates
                        left++;
                    while (right - 1 > left && nums[right] == nums[right - 1])// Skip equal elements to avoid duplicates
                        right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        ThreeSumZero ts = new ThreeSumZero();
        int[] input = new int[]{0, -1, 2, -3, 1};
        System.out.println(ts.threeSum(input));
    }
}
