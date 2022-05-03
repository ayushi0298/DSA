package Interview;

import java.util.HashMap;

//https://docs.google.com/document/d/1d7H9knHVCbYhWUJMVoZRdD63l5mIgel0h7POvbh2-HY/edit

//TC: O(N) + 0(9)= 0(N)
//SC: Hashmap of constant size
public class InterviewMockKarat {
    //Part one
    public boolean completeHand(String number) {
        int countPair = 0;
        int others = 0;
        HashMap<Character, Integer> storeCount = new HashMap<>();
        for (int c = 0; c < number.length(); c++) {
            if (!storeCount.containsKey(number.charAt(c))) {
                storeCount.put(number.charAt(c), 1);

            }
            storeCount.put(number.charAt(c), storeCount.get(number.charAt(c)) + 1);
        }

        for (char key : storeCount.keySet()) {
            if ((storeCount.get(key) % 3) == 0) {
                storeCount.put(key, 0);
            } else {
                storeCount.put(key, storeCount.get(key) % 3);
            }
        }
        for (char key : storeCount.keySet()) {
            if (storeCount.get(key) != 0 && (storeCount.get(key) % 2) == 0) {
                storeCount.put(key, 0);
                countPair++;
                if (countPair > 1) {
                    return false;
                }
            } else {
                storeCount.put(key, storeCount.get(key) % 2);
            }
        }
        if (countPair == 0) {
            return false;
        }
        for (char key : storeCount.keySet()) {
            if (storeCount.get(key) != 0) {
                others++;
            }
            if (others >= 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        InterviewMockKarat it = new InterviewMockKarat();
        String tile = "1111122222";
        System.out.println(it.completeHand(tile));
    }
}
