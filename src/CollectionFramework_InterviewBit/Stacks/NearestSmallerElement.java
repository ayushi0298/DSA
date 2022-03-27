package CollectionFramework_InterviewBit.Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
    public  int[] prevSmaller(int[] A) {
        int[] output= new int[A.length];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : A) {
            while (!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
            }
            ans.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        for(int i=0;i<ans.size();i++){
            output[i]=ans.get(i);
        }
        return output;
    }

    public static void main(String args[]) {
        NearestSmallerElement ng = new NearestSmallerElement();
        int[] myArray = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(ng.prevSmaller(myArray)));

    }
}
