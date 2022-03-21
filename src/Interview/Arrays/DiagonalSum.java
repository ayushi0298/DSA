package Interview.Arrays;
//https://www.geeksforgeeks.org/efficiently-compute-sums-of-diagonals-of-a-matrix/
public class DiagonalSum {

    public void sumDiagonal(int[][] input) {
        int first = 0, second = 0;
        for (int i = 0; i < input.length; i++) {
            first = first + input[i][i];
            second = second + input[i][input.length - i - 1];
        }

        System.out.println("first Diagonal:"
                + first);

        System.out.println("second Diagonal:"
                + second);
    }


    public static void main(String args[]) {
        DiagonalSum ds = new DiagonalSum();
        int input[][] = {{1, 2},
                {5, 8}};
        ds.sumDiagonal(input);


    }


}
