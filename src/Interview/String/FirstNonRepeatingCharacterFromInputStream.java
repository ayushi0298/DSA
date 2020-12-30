package Interview.String;

import java.io.IOException;
import java.util.Arrays;
//https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/?ref=lbp
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
        String str = "abcabe";
        //String str = "aabc";
        //(1, 0)(1, 1)
        System.out.println(fn.firstNonRepeating(str));
        //fn.firstNonRepeating(str);
//        int a_ascii= 'a';
//        System.out.println(a_ascii);

    }
}
