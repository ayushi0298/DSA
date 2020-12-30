package Interview.String;

import java.io.IOException;
import java.util.Arrays;
//https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/?ref=lb?
/*
Algorithm:
1)we make a array of pair which stores count of the occurence of characters and first occurence index and index is the ascii value of charcters.
2)and at each point we return the first non repeating character by traversing array each time
*/
public class FirstNonRepeatingCharacterFromInputStream {
    Pair<Integer, Integer> storeCountAndFirstOccurence[] = new Pair[256];
//    String output = "";

    public static class Pair<I extends Number, I1 extends Number> {
        int value1;
        int value2;

        public Pair(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "value1=" + value1 +
                    ", value2=" + value2 +
                    '}';
        }
    }

    /*public String wrongfirstNonRepeating(String input) {

        for (int i = 0; i < input.length(); i++) {
            Pair current;
            if (storeCountAndFirstOccurence[input.charAt(i) - 'a'] == null) {
                current = new Pair(1, i);
                storeCountAndFirstOccurence[input.charAt(i) - 'a'] = current;
                if(current.value2>=currentIndex){
                    currentIndex = current.value2;
                }
                output = output + input.charAt(currentIndex);

            } else {
                current = storeCountAndFirstOccurence[input.charAt(i) - 'a'];
                current.value1++;
                currentIndex = current.value2++;
                output = output + "-1";
            }
        }
        return output;

    }*/
   //this api is checking the character is first time coming or not. if not we will create new reference for it.
    public String firstNonRepeating(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            Pair current;
            if (storeCountAndFirstOccurence[input.charAt(i) - 'a'] == null) {
                current = new Pair(1, i);
                storeCountAndFirstOccurence[input.charAt(i) - 'a'] = current;
            } else {
                current = storeCountAndFirstOccurence[input.charAt(i) - 'a'];
                current.value1++;
            }
            output = output + findMinimum();
        }
        return output;
    }
    //this api is giving us the min at each stage by traversing the array every time.
    public char findMinimum() {
        char c = '0';
        int min = Integer.MAX_VALUE;//dont make it global,
//        System.out.println(Arrays.toString(storeCountAndFirstOccurence));
        for (int i = 0; i < storeCountAndFirstOccurence.length; i++) {
            if (storeCountAndFirstOccurence[i] != null && storeCountAndFirstOccurence[i].value1 == 1 && min > storeCountAndFirstOccurence[i].value2) {
                min = storeCountAndFirstOccurence[i].value2;
                c = (char) ('a' + min);
            }
        }
        return c;
    }

    public static void main(String args[]) throws IOException {
        FirstNonRepeatingCharacterFromInputStream fn = new FirstNonRepeatingCharacterFromInputStream();
        //String str = "abcabe";
        String str = "aabc";
        //(1, 0)(1, 1)
        System.out.println(fn.firstNonRepeating(str));
        //fn.firstNonRepeating(str);
//        int a_ascii= 'a';
//        System.out.println(a_ascii);

    }
}
