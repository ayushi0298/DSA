package CollectionFramework_InterviewBit.DynamicProgramming;

import java.util.Arrays;

//https://www.interviewbit.com/problems/stairs/
//BOTTOM UP APPROACH ( when u know the base case)
public class Stairs {
    public int climbStairs(int A) {
        int dp[] = new int[A];
        if (A == 0) {
            return 1;
        }
        if (A == 1) {
            return 1;
        }
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < A; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        //System.out.println(Arrays.toString(dp));

        return dp[A - 1];
    }

    public static void main(String args[]) {
        Stairs lc = new Stairs();
        int A = 4;
        System.out.println(lc.climbStairs(A));
    }
}
