package CollectionFramework.Recursion;

import java.util.Arrays;
import java.util.HashMap;

//how to find nth fibonacci
public class NthFibnocci {
    long[] DP = new long[100000];

    //using recursion
    public int returnNthFibnocci(int n) {
        if (n == 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int x = returnNthFibnocci(n - 1);
        int y = returnNthFibnocci(n - 2);
        return x + y;

    }

    //using Dynamic programming
    public long returnNthFibnocciDP(int n) {
        if (n <= 0) {
            return -1l;
        }
        if (n == 1 || n == 2) {
            return 1l;
        }
        if (DP[n] != -1) {
            return DP[n];
        }
        DP[n] = returnNthFibnocciDP(n - 1) + returnNthFibnocciDP(n - 2);
        return DP[n];

    }

    public HashMap<Integer, Long> hm = new HashMap<Integer, Long>();

    //using hashmap
    public Long getFibonacciNumberTopDown(int n) {
        if (hm.containsKey(n)) return hm.get(n);
        if (n == 0) return 0L;
        if (n == 1) return 1L;
        Long nthValue = getFibonacciNumberTopDown(n - 1) + getFibonacciNumberTopDown(n - 2);
        hm.put(n, nthValue);
        return nthValue;
    }

    public static void main(String args[]) {
        NthFibnocci nth = new NthFibnocci();

        //best way to initialize array with -1
        Arrays.fill(nth.DP, -1);
//        System.out.println(Arrays.toString(nth.DP));
        System.out.println(nth.returnNthFibnocciDP(7));
//        System.out.println(nth.getFibonacciNumberTopDown(50));
        //System.out.println(nth.returnNthFibnocci(30));

    }
}
