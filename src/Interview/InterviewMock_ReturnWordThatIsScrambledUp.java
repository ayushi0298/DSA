package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class InterviewMock_ReturnWordThatIsScrambledUp {
    //space: O(s) for every word in array we need 26 size hashmap
    //time: O(w * s) for every word in array we need
    public String find_embedded_word(String[] myArray, String s1) {
        //ArrayList<String> output = new ArrayList<>();
        String stringFound;
        HashMap<Character, Integer> storesCharacters = new HashMap<>();
        for (char i = 0; i < s1.length(); i++) {
            if (!storesCharacters.containsKey(s1.charAt(i))) {
                storesCharacters.put(s1.charAt(i), 1);
            }
            storesCharacters.put(s1.charAt(i), storesCharacters.get(s1.charAt(i)) + 1);
        }
        for (int i = 0; i < myArray.length; i++) {
            boolean found = true;
            stringFound = myArray[i];
            HashMap<Character, Integer> storesWords = new HashMap<>();
            for (char j = 0; j < myArray[i].length(); j++) {
                if (!storesWords.containsKey(myArray[i].charAt(j))) {
                    storesWords.put(myArray[i].charAt(j), 1);
                }
                storesWords.put(myArray[i].charAt(j), storesWords.get(myArray[i].charAt(j)) + 1);

            }
            for (Character key : storesWords.keySet()) {
                if (storesWords.get(key) > storesCharacters.getOrDefault(key, 0)) {
                    // System.out.println("key is: " + storesWords.get(key));
                    found = false;
                }

            }
            /*if (found == true) {
                output.add(stringFound);
            }*/
            if (found == true) {
                return stringFound;
            }
        }
        /*if (output.size() != 0) {
            return output;
        } else {
            return null;
        }*/
        return null;
    }

    public ArrayList<int[]> dfs(char[][] input, String s1, int i, int j, int k) {
        //  System.out.println("LENTH " + s1.length());
        ArrayList<int[]> output = new ArrayList<>();
        if (k == s1.length() - 1 && s1.charAt(k) == input[i][j]) {
            //System.out.println(" ADDED HERE");
            output.add(new int[]{i, j});
            return output;
        }
        if (k < s1.length() && s1.charAt(k) == input[i][j]) {
            if (i + 1 < input.length) {
                output = dfs(input, s1, i + 1, j, k + 1);
                if (output.size() != 0) {
                    // System.out.println(" ADDED PAIR");
                    output.add(new int[]{i, j});
                    return output;
                }
            }
            if (j + 1 < input[0].length) {
                output = dfs(input, s1, i, j + 1, k + 1);
                if (output.size() != 0) {
                    // System.out.println(" ADDED PAIRsssss");
                    output.add(new int[]{i, j});
                    return output;
                }
            }
        }

        return output;
    }

    //time complexity: r * c * lengthOfString
    // space:  r* c* lengthOfString
    public ArrayList<int[]> find_embedded_word_in2Darray(char[][] input, String s1) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (s1.charAt(0) == input[i][j]) {
                    //System.out.println(i + " and"  + j);
                    ArrayList<int[]> output = dfs(input, s1, i, j, 0);
                    if (!output.isEmpty()) {
                        return output;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String args[]) {
        InterviewMock_ReturnWordThatIsScrambledUp it = new InterviewMock_ReturnWordThatIsScrambledUp();
        char[][] grid1 = {
                {'c', 'c', 'x', 't', 'i', 'b'},
                {'c', 'c', 'a', 't', 'n', 'i'},
                {'a', 'c', 'n', 'n', 't', 't'},
                {'t', 'c', 's', 'i', 'p', 't'},
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'o', 'a', 'a', 'a', 'o', 'o'},
                {'k', 'a', 'i', 'c', 'k', 'i'}
        };
        char[][] grid2 = {{'a'}};
        String[] word9 = new String[]{"a"};

        String[] inputs = new String[]{"catnip", "cccc", "s", "bit", "aoi", "ki", "aaa", "ooo"};
        //String[] inputs = new String[]{"ti"};

        //  System.out.println(Arrays.toString(it.find _embedded_word_in2Darray(grid2,word9)));
        for (String input : inputs) {
        System.out.println(input);
        ArrayList<int[]> result = it.find_embedded_word_in2Darray(grid1, input);
        Collections.reverse(result);
        for (int[] i : result) {
            System.out.println(Arrays.toString(i));
        }
    }
}
    /*public static void main(String args[]) {
        InterviewMock_ReturnWordThatIsScrambledUp it = new InterviewMock_ReturnWordThatIsScrambledUp();
        String[] myArray = new String[]{"baby", "dog", "bird", "sye", "ax"};
        String s1 = "babyusyedog";
        System.out.println(it.find_embedded_word(myArray, s1));
    }*/
}
