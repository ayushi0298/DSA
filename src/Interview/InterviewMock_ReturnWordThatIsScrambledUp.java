package Interview;

import java.util.HashMap;

public class InterviewMock_ReturnWordThatIsScrambledUp {
    public String find_embedded_word(String[] myArray, String s1) {
        String stringFound;
        HashMap<Character, Integer> storesCharacters = new HashMap<>();
        for (char i = 0; i < s1.length(); i++) {
            if (!storesCharacters.containsKey(s1.charAt(i))) {
                storesCharacters.put(s1.charAt(i), 1);
            }
            storesCharacters.put(s1.charAt(i), storesCharacters.get(s1.charAt(i)) + 1);
        }
        for (int i = 0; i < myArray.length; i++) {
            boolean found = true;
            stringFound = myArray[i];
            HashMap<Character, Integer> storesWords = new HashMap<>();
            for (char j = 0; j < myArray[i].length(); j++) {
                if (!storesWords.containsKey(myArray[i].charAt(j))) {
                    storesWords.put(myArray[i].charAt(j), 1);
                }
                storesWords.put(myArray[i].charAt(j), storesWords.get(myArray[i].charAt(j)) + 1);

            }
            for (Character key : storesWords.keySet()) {
                if (storesWords.get(key) > storesCharacters.getOrDefault(key, 0)) {
                    //System.out.println("key is: " + storesWords.get(key));
                    found = false;
                }

            }
            if(found==true){
                return stringFound;
            }
        }
        return null;
    }

    public static void main(String args[]) {
        InterviewMock_ReturnWordThatIsScrambledUp it = new InterviewMock_ReturnWordThatIsScrambledUp();
        String[] myArray = new String[]{"baby","dog", "bird","car","ax"};
        String s1 = "breakingdog";
        System.out.println(it.find_embedded_word(myArray, s1));

    }
}
