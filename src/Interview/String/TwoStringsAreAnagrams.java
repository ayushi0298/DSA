package Interview.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoStringsAreAnagrams {
    public boolean checkAnagrams(String s1, String s2) {
        HashMap<Character, Integer> countStore = new HashMap<>();
        for (char i = 0; i < s1.length(); i++) {
            int count = countStore.containsKey(s1.charAt(i)) ? countStore.get(s1.charAt(i)) : 0;
            countStore.put(s1.charAt(i), count + 1);
        }
        for (char i = 0; i < s2.length(); i++) {
            if (countStore.containsKey(s2.charAt(i))) {
                int count = countStore.get(s2.charAt(i));
                countStore.put(s2.charAt(i), count - 1);
            }
        }
        for (Integer x : countStore.values()) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        TwoStringsAreAnagrams ts = new TwoStringsAreAnagrams();
        String s1 = "abc";
        String s2 = "catt";
        String s3 = "tac";
        System.out.println(ts.checkAnagrams(s2, s3));

    }
}
