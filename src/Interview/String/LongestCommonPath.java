package Interview.String;

import java.util.ArrayList;
//https://www.geeksforgeeks.org/adobe-interview-experience-off-campus/
public class LongestCommonPath {
    public String findCommonPath(ArrayList<String> input) {
        String temp = input.get(0), common;
        int size = input.size();
        for (int i = 1; i < size; i++) {
            common = "";
            for (int j = 0; j < Math.min(temp.length(), input.get(i).length()); j++) {
                if (temp.charAt(j) == input.get((i)).charAt(j)) {
                    common = common + temp.charAt(j);
                } else {
                    break;
                }
            }
            temp = common;
        }
        return temp;
    }

    public static void main(String args[]) {
        LongestCommonPath ld = new LongestCommonPath();
        ArrayList<String> input = new ArrayList<>();
        input.add("abcdes");
        input.add("abd");
        input.add("abc");
        System.out.println(ld.findCommonPath(input));

    }
}
