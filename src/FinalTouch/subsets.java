package FinalTouch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void findSubsets(int[] nums, List<List<Integer>> ans, List<Integer> curr, int idx) {
        ans.add(new ArrayList<>(curr));
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            System.out.println(curr);
            findSubsets(nums, ans, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String args[]) {
        subsets s = new subsets();
        int[] input = new int[]{1, 2, 3, 7, 8,};
        //System.out.println(input.size());
        System.out.println(s.subsets(input));
    }
}
