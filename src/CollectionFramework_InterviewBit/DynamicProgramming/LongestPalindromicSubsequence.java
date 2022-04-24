package CollectionFramework_InterviewBit.DynamicProgramming;

import CollectionFramework_InterviewBit.Stream;

public class LongestPalindromicSubsequence {
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public int palindromicString(char[] input, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (input[i] == input[j] && (i + 1) == j) {
            return 2;
        }
        if (input[i] == input[j]) {
            return palindromicString(input, i + 1, j - 1) + 2;
        }
        return max((palindromicString(input, i, j - 1)), (palindromicString(input, i + 1, j)));
    }

    public int solve(String A) {
        char[] input = A.toCharArray();
        int length = palindromicString(input, 0, A.length() - 1);
        return length;
    }

    public static void main(String args[]) {
        LongestPalindromicSubsequence lc = new LongestPalindromicSubsequence();
        String str1 = "ccdbaeeceecabaacebcaebdceaacdcdcbbadcebcaaceaebcdacccaedcbccacedaacdbaaeacdbeedccceeabececcc";
        System.out.println(lc.solve(str1));
    }
}
