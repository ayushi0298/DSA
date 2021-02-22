package Interview.Stacks;

import java.util.Stack;

public class BalancedParanthesis {
    public boolean balance(String input) {
        Stack<Character> storesParenthesis = new Stack<>();
        for (char i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '[' || input.charAt(i) == '{' || input.charAt(i) == '(') {
                storesParenthesis.push(input.charAt(i));
            }
            if (input.charAt(i) == ']' || input.charAt(i) == '}' || input.charAt(i) == ')') {
                if (storesParenthesis.peek() == '(') {
                    storesParenthesis.pop();
                    if (input.charAt(i) == '}' || input.charAt(i) == ']') {
                        return false;
                    }
                    break;
                }
                if (storesParenthesis.peek() == '{') {
                    storesParenthesis.pop();
                    if (input.charAt(i) == ']' || input.charAt(i) == ')') {
                        return false;
                    }
                    break;
                }
                if (storesParenthesis.peek() == '[') {
                    storesParenthesis.pop();
                    if (input.charAt(i) == '}' || input.charAt(i) == ')') {
                        return false;
                    }
                    break;
                }
            }
        }
        if (storesParenthesis.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        BalancedParanthesis bp = new BalancedParanthesis();
        String input = "[{}]{}";
        System.out.println(bp.balance(input));

    }
}
