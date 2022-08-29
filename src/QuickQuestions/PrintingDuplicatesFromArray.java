package QuickQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/////    PRINT DUPLICATES ELEMENTS IN A ARRAY        /////////
public class PrintingDuplicatesFromArray {
    public void printDupli(int input[]) {
        HashMap<Integer, Integer> storeElements = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int count = storeElements.containsKey(input[i]) ? storeElements.get(input[i]) : 0;
            storeElements.put(input[i], count + 1);
        }
        //to print hashmap
       /* for (Map.Entry<Integer, Integer> entry : storeElements.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }*/
        for (Map.Entry<Integer, Integer> entry : storeElements.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void main(String args[]) {
        PrintingDuplicatesFromArray pd = new PrintingDuplicatesFromArray();
        int arr[] = new int[]{1, 2, 3, 45, 3, 2, 4, 6, 9, 9, 4};
        pd.printDupli(arr);

    }
}
