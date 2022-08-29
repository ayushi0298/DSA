package QuickQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
///// PRINT NO  DUPLICATES ?/////////

public class PrintingNonDuplicatesFromString {
    public void printNonDupli(String str1) {
        HashMap<Character, Integer> storeElements = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            int count = storeElements.containsKey(str1.charAt(i)) ? storeElements.get(str1.charAt(i)) : 0;
            storeElements.put(str1.charAt(i), count + 1);
        }
        for (Map.Entry<Character, Integer> entry : storeElements.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void main(String args[]) {
        PrintingNonDuplicatesFromString pd = new PrintingNonDuplicatesFromString();
        String str1 = "edededrrtyu";
        pd.printNonDupli(str1);
    }
}
