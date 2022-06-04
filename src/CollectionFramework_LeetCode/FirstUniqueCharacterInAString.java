package CollectionFramework_LeetCode;

import java.util.HashSet;
import java.util.LinkedHashSet;
//https://leetcode.com/problems/first-unique-character-in-a-string/

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] storesOccurences = new int[256];
        for (int i = 0; i < 256; i++) {
            storesOccurences[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (storesOccurences[s.charAt(i)] == -1) {
                storesOccurences[s.charAt(i)] = i;
            } else {
                storesOccurences[s.charAt(i)] = -2;
            }
        }
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < 256; i++) {
            if (storesOccurences[i] >= 0)
                res = Math.min(res, storesOccurences[i]);
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        } else return res;
    }

    public int firstUniqueChar(String input) {
        LinkedHashSet<Character> freq = new LinkedHashSet<>();
        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (set.contains(c)) {
                continue;
            } else if (!freq.contains(c))
                freq.add(c);
            else {
                freq.remove(c);
                set.add(c);
            }
        }
        if (!freq.isEmpty()) {
            return input.indexOf(freq.iterator().next());
        }
        return -1;
    }

    public static void main(String args[]) {
        FirstUniqueCharacterInAString fu = new FirstUniqueCharacterInAString();
        String s = "ayushi mishra";
        System.out.println(fu.firstUniqChar(s));


    }
}
