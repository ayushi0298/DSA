/*
* import java.util.HashMap;

public class Demo2 {
    public HashMap<Character, Integer> returnHashMap(String s2) {
        HashMap<Character, Integer> storePatternOccurences = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            if (storePatternOccurences.containsKey(s2.charAt(i))) {
                storePatternOccurences.put(s2.charAt(i), storePatternOccurences.get(i) + 1);
            } else {
                storePatternOccurences.put(s2.charAt(i), 1);
            }
        }
        return storePatternOccurences;
    }

    public String findMinWindow(String s1, String s2) {

        int start = 0, start_index = 0, min_length = Integer.MAX_VALUE, count = 0;
        HashMap<Character, Integer> storePatternOccurences = new HashMap<>();
        HashMap<Character, Integer> storeOccurences = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            if (storePatternOccurences.containsKey(s2.charAt(i))) {
                storePatternOccurences.put(s2.charAt(i), storePatternOccurences.get(i) + 1);
            } else {
                storePatternOccurences.put(s2.charAt(i), 1);
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            if (storeOccurences.containsKey(s1.charAt(i))) {
                storeOccurences.put(s1.charAt(i), storeOccurences.get(i) + 1);
            } else {
                storeOccurences.put(s2.charAt(i), 1);
            }
            if (storeOccurences.get(s1.charAt(i)) <= storePatternOccurences.get(s1.charAt(i))) {
                count++;
            }
            if (count == s2.length()) {
                while()
            }
        }


    }
}*/