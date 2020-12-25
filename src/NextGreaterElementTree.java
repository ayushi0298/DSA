import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/
//problem: we have to find nearest greatest element of each value.
/*ALGORITHM:
1) use a stack and a arraylist and will initialize whole arraylist with -1
2)will traverse the whole input arraylist an for each i we will check 2 conditions:
  a) our stack should not be empty AND
  b)element at i is greater than top of the stack.
3) if above condition holds the value true then we will just do arraylist.set(stack.top, i) where stack.top is the index of the elemnt whose greater we are finding and i is the index of the found element.
  and if not then we will just push that in stack.
 */
public class NextGreaterElementTree {
    public void findGreater(ArrayList<Integer> input) {
        ArrayList<Integer> storeIndexes = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.size(); i++) {
            storeIndexes.add(-1);
        }
        //System.out.println(storeIndexes);
        for (int i = 0; i < input.size(); i++) {
            while (!stack.isEmpty() && input.get(i) > input.get(stack.peek())) {//while use kiya bc we are checking ki input.get(stack.peek()) kis kis ka greatest element ho sakta
                storeIndexes.set(stack.peek(), i);
                stack.pop();
            }
            stack.push(i);
//            System.out.println(i);
        }
        System.out.println(storeIndexes);
    }

    public static void main(String args[]) {
        NextGreaterElementTree bst = new NextGreaterElementTree();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(40, 32, 30, 35));
        bst.findGreater(input);
    }
}
