package Interview.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
public class PrintAnagramsTogether {
    public String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public void printAnagrams(String input[]) {
        HashMap<String, ArrayList<String>> storeAnagrams = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            String s = input[i];
            String sortedString = sortString(input[i]);
            if (storeAnagrams.containsKey(sortedString)) {
                storeAnagrams.get(sortedString).add(s);
            } else {
                ArrayList<String> current = new ArrayList<>();
                current.add(s);
                storeAnagrams.put(sortedString, current);
            }
        }
        for (String s : storeAnagrams.keySet()) {
            ArrayList<String> values = storeAnagrams.get(s);
            if (values.size() >=1) {
                System.out.println(values);
            }
        }
    }

    public static void main(String args[]) {
        PrintAnagramsTogether pa=new PrintAnagramsTogether();
        String input[] = {"cat", "tac","dog", "god","ased","desa","akash","kasha","abcd","dcba","cdba","bacd"};
        pa.printAnagrams(input);


    }
}
