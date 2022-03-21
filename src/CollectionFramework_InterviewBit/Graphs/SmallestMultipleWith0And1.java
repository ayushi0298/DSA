package CollectionFramework_InterviewBit.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/
public class SmallestMultipleWith0And1 {
    public static int mod(String t, int N) {
        int r = 0;
        for (int i = 0; i < t.length(); i++) {
            r = r * 10 + (t.charAt(i) - '0');
            r %= N;
        }
        return r;
    }

    public String multiple(int A) {
        Queue<String> storesMultiple = new LinkedList<>();
        Set<Integer> storesRemainder = new HashSet<>();
        String initial = "1";
        storesMultiple.add(initial);
        while (!storesMultiple.isEmpty()) {
            initial = storesMultiple.remove();
            int remainder = mod(initial, A);
            if (remainder == 0) {
                return initial;
            } else if (!storesRemainder.contains(remainder)) {
                storesRemainder.add(remainder);
                storesMultiple.add(initial + "1");
                storesMultiple.add(initial + "0");

            }
        }
        return "";

    }


    public static void main(String args[]) {
        SmallestMultipleWith0And1 sm = new SmallestMultipleWith0And1();
        int k = 55;
        System.out.println(sm.multiple(k))  ;

    }
}
