package FinalTouch;

import java.util.ArrayList;
//https://www.geeksforgeeks.org/find-k-closest-elements-given-value/

public class KClosestPointsInSortedArray {
    public int findCrossoverPoint(int arr[], int low, int high, int x) {

        if (arr[high] <= x) {
            return high;
        }
        if (arr[low] > x) {
            return low;
        }

        int mid = (low + high) / 2;

        if (arr[mid] <= x && arr[mid + 1] > x)
            return mid;
        if (arr[mid] < x)
            return findCrossoverPoint(arr, mid + 1, high, x);

        return findCrossoverPoint(arr, low, mid - 1, x);

    }

    public ArrayList<Integer> printKclosest(int arr[], int x, int k) {
        ArrayList<Integer> output = new ArrayList<>();
        int left = findCrossoverPoint(arr, 0, arr.length - 1, x);
        System.out.println(left);
        int right = left + 1;
        int count = 0;
        if (arr[left] == x) {
            left--;
        }
        while (left >= 0 && right < arr.length && count < k) {
            if (x - arr[left] < arr[right] - x) {
                output.add(arr[left]);
                left--;
            } else {
                output.add(arr[right]);
                right++;
            }
            count++;
        }
        while (count < k && left >= 0) {
            output.add(arr[left--]);
            count++;
        }
        while (count < k && right < arr.length) {
            output.add(arr[right++]);
            count++;
        }
        return output;
    }

    public static void main(String args[]) {
        KClosestPointsInSortedArray kc = new KClosestPointsInSortedArray();
        int[] input = new int[]{11, 12, 16, 22};
        int k = 2;
        int X = 23;
        System.out.println(kc.printKclosest(input, X, k));
    }
}
