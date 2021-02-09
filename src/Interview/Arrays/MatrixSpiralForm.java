package Interview.Arrays;

//https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
public class MatrixSpiralForm {
    int rows = 4;
    int columns = 4;

    public void printSpiralForm(int[][] input, int i, int j, int rows, int columns) {
        if (i >= rows || j >= columns) {
            return;
        }
        for (int k = i; k < columns; k++) {
            System.out.println(input[i][k]);
        }
        for (int k = i + 1; k < rows; k++) {
            System.out.println(input[k][columns - 1]);
        }

        for (int k = columns - 2; k >= j; k--) {
            System.out.println(input[rows - 1][k]);
        }

        for (int k = rows - 2; k > i; k--) {
            System.out.println(input[k][j]);
        }

        rows = rows - 1;
        columns = columns - 1;
        printSpiralForm(input, i + 1, j + 1, rows, columns);

    }


    public static void main(String args[]) {
        MatrixSpiralForm ms = new MatrixSpiralForm();
        int input[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        ms.printSpiralForm(input, 0, 0, ms.rows, ms.columns);


    }
}
