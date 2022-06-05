package CollectionFramework_LeetCode;
//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int count = 0;

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                } else {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                count = count + matrix[i][j];
            }
        }
        return count;

    }

    public static void main(String args[]) {
        CountSquareSubmatricesWithAllOnes cq = new CountSquareSubmatricesWithAllOnes();
        int[][] input = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println(cq.countSquares(input));

    }
}
