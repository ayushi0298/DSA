public class FindPair {
    int difference = Integer.MAX_VALUE;
    int pair1 = 0, pair2 = 0;
    public void findPair(int[] a1, int[] a2, int target) {

        int left = 0, right = a2.length - 1;

        while (left < a1.length && right >= 0) {

            if (Math.abs(a1[left] + a2[right] - target) <= difference) {

                pair1 = left;
                pair2 = right;
                System.out.println(" Pair : " + a1[pair1] + " " + a2[pair2]);
                difference = Math.abs(a1[left] + a2[right] - target);
            }

            if (a1[left] + a2[right] >difference) {
                System.out.println(difference);
                right--;
            } else {
                left++;
            }

        }
        System.out.println(" Pair : " + a1[pair1] + " " + a2[pair2]);
    }

    public static void main(String args[]) {
        FindPair fd = new FindPair();
        int[] a1 = new int[]{1, 2, 3};
        int[] a2 = new int[]{4, 5, 6};
        int k = 10;
        fd.findPair(a1, a2, k);

    }
}