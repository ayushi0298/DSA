package CollectionFramework_InterviewBit.TwoPointers;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height) {
        int waterTrapped = 0;
        int left[] = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        int right[] = new int[height.length];
        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            waterTrapped += Math.min(left[i], right[i]) - height[i];
        }
        return waterTrapped;
    }


    public static void main(String args[]) {
        TrappingRainWater tr = new TrappingRainWater();
        int[] input = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(tr.trap(input));

    }
    //TC: O(n)
    //SC: n+n= 2n= O(n)
}
