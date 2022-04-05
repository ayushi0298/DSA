package CollectionFramework_InterviewBit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class demoBufferreader {
    static int lengthOfSmallestSubsequence(int K, int[] v) {
        
        Queue<Integer> pq =
                new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < v.length; i++) {
            pq.add(v[i]);
        }
        int sum = 0, count = 0;

        while (!pq.isEmpty() && sum < K) {
            sum += pq.peek();
            pq.remove();
            count++;
        }

        if (sum < K) {
            return -1;
        }
        return count;
    }

    static int[] method(String str) {

        String[] splitArray = str.split(" ");
        int[] array = new int[splitArray.length];
        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int T = Integer.parseInt(bf.readLine());
        int[] output = method(str);
        System.out.println(lengthOfSmallestSubsequence(T, output));


    }

}
