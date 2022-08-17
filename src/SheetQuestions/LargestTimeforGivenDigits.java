package SheetQuestions;

import java.util.HashMap;

class LargestTimeforGivenDigits {
    boolean flag = false;
    String time = "";

    public String largestTimeFromDigits(int[] arr) {
        HashMap<Integer, Integer> storeDigits = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (storeDigits.containsKey(arr[i])) {
                storeDigits.put(arr[i], storeDigits.get(arr[i]) + 1);
            } else {
                storeDigits.put(arr[i], 1);
            }
        }

        for (int i = 2; i >= 0; i--) {
            if (storeDigits.getOrDefault(i, -1) > 0) {
                storeDigits.put(i, storeDigits.get(i) - 1);
                flag = true;
                time = time + i;
                break;
            }
        }
        if (!flag) {
            return "";
        }
        flag = false;
        if (time.charAt(0) == '2') {
            for (int i = 3; i >= 0; i--) {
                if (storeDigits.getOrDefault(i, -1) > 0) {
                    storeDigits.put(i, storeDigits.get(i) - 1);
                    flag = true;
                    time = time + i;
                    break;
                }
            }
        } else {
            for (int i = 9; i >= 0; i--) {
                if (storeDigits.getOrDefault(i, -1) > 0) {
                    storeDigits.put(i, storeDigits.get(i) - 1);
                    flag = true;
                    time = time + i;
                    break;
                }
            }
        }
        if (!flag) {
            return "";
        }
        time += ":";

        flag = false;
        for (int i = 5; i >= 0; i--) {
            if (storeDigits.getOrDefault(i, -1) > 0) {
                storeDigits.put(i, storeDigits.get(i) - 1);
                flag = true;
                time += i;
                break;
            }
        }
        if (!flag) {
            return "";
        }

        flag = false;
        for (int i = 9; i >= 0; i--) {
            if (storeDigits.getOrDefault(i, -1) > 0) {

                storeDigits.put(i, storeDigits.get(i) - 1);
                flag = true;
                time += i;
                break;
            }
        }

        if (!flag) {
            return "";
        }
        return time;
    }

    public static void main(String args[]) {
        LargestTimeforGivenDigits lt = new LargestTimeforGivenDigits();
        int[] input = new int[]{2, 0, 6, 6};
        System.out.println(lt.largestTimeFromDigits(input));
    }

}