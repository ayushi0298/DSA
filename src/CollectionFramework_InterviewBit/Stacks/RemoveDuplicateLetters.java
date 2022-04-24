package CollectionFramework_InterviewBit.Stacks;

import java.util.HashSet;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        String output = "";
        HashSet<Character> storesCharacters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!storesCharacters.contains(s.charAt(i))) {
                //System.out.println("i:" + i + "char: " + s.charAt(i));
                storesCharacters.add(s.charAt(i));
            }
            i++;
        }
        for (Character character : storesCharacters) {
            output = output + character;
        }
        //System.out.println(output);
        return output;

    }

    public static void main(String args[]) {
        RemoveDuplicateLetters rd = new RemoveDuplicateLetters();
        String s = "cbacdcbc";
        System.out.println(rd.removeDuplicateLetters(s));
    }
}
