package CollectionFramework_InterviewBit.Recursion;

import java.util.Arrays;

//https://www.interviewbit.com/problems/sum-of-fibonacci-numbers/
public class SumOfFibonacciNumbers {

    public static int sumOfFibonacciNumbers(int n) {
        int sum1, terms = 0, sum2 = 0, temp, lastIndex = 0;
        int fibnonacci[] = new int[n + 1];
        fibnonacci[0] = 1;
        fibnonacci[1] = 1;
        for (int i = 2; i <= n; i++) {
            sum1 = fibnonacci[i - 1] + fibnonacci[i - 2];
            if (sum1 > n) {
                break;
            }
            lastIndex = i;
            fibnonacci[i] = sum1;
        }
        System.out.println(Arrays.toString(fibnonacci));
        for (int i = lastIndex; i >= 0; i--) {
            if (fibnonacci[i] <= n) {
                n = n - fibnonacci[i];
                terms++;
            }
        }
        return terms;
    }

    public static void main(String args[]) {
        SumOfFibonacciNumbers sm = new SumOfFibonacciNumbers();
        System.out.println(sumOfFibonacciNumbers(11));
        //sumOfFibonacciNumbers(10);

    }
}



