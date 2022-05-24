package CollectionFramework_InterviewBit.BinarySearch;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }

    public static void main(String args[]) {
        SearchInsertPosition si = new SearchInsertPosition();
        int[] array = new int[]{1, 3, 5, 6, 11, 45};
        int target = 4;
        System.out.println(si.searchInsert(array, target));

    }

}
