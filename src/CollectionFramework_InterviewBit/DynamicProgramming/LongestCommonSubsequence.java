package CollectionFramework_InterviewBit.DynamicProgramming;

//https://www.interviewbit.com/problems/longest-common-subsequence/
//TOP DOWN APPROACH( RECURSION + MEMOISATION)
public class LongestCommonSubsequence {
    public int longestSubsequence(char[] c1, char[] c2) {
        int m = c1.length;
        int n = c2.length;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public int solve(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        return longestSubsequence(c1, c2);
    }

    public static void main(String args[]) {
        LongestCommonSubsequence lc = new LongestCommonSubsequence();
        String str1 = "abcc";
        String str2 = "abdc";
        System.out.println(lc.solve(str1, str2));
    }
}
