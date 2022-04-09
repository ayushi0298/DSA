package CollectionFramework_LeetCode;

import java.util.HashMap;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int length = 0, start = 0;
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            if (lastOccurence.containsKey(s.charAt(end))) {
                start = Math.max(start, lastOccurence.get(s.charAt(end)) + 1);
            }
            lastOccurence.put(s.charAt(end), end);
            length = Math.max(length, end - start + 1);
        }
        return length;

    }

    public static void main(String args[]) {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        String s = "qqqqqqwed";
        System.out.println(ls.lengthOfLongestSubstring(s));
    }
}
