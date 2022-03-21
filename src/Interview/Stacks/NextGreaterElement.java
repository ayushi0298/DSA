package Interview.Stacks;

import java.util.Arrays;
import java.util.Stack;
//https://www.interviewbit.com/problems/nextgreater/
public class NextGreaterElement {
    public int[] nextGreater(int[] A) {
        int[] output = new int[A.length];
        Arrays.fill(output,-1);
        Stack<Integer> storesElements = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!storesElements.isEmpty() && A[i] > A[storesElements.peek()]) {
                output[storesElements.peek()] = A[i];
                storesElements.pop();
            }
            storesElements.push(i);
        }

        return output;
    }

    public static void main(String args[]) {

        NextGreaterElement ng = new NextGreaterElement();
        int[] myArray = {13, 14, 15};
        System.out.println((Arrays.toString(ng.nextGreater(myArray))));

    }


}
