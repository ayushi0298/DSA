package Interview.Arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-the-missing-number/
public class FindMissingNumber {
    public int findMissing(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] + 1) != arr[i + 1]) {
                return arr[i] + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        FindMissingNumber fd = new FindMissingNumber();
        int[] arr = new int[]{1, 2, 4, 6, 3, 7, 8};
        System.out.println(fd.findMissing(arr));
    }
}
