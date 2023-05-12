package JavaAdvanced2023MultidimensionalArrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    static int firstMatrixLine;
    static int secondMatrixLine;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = new char[rows][cols];
        for (int row = 0; row < matrix1.length; row++) {
            char[] rowFromConsole = scanner.nextLine().replaceAll("\\s+", "")
                    .toCharArray();
            matrix1[row] = rowFromConsole;
        }
        char[][] matrix2 = new char[rows][cols];
        for (int row = 0; row < matrix2.length; row++) {
            char[] rowFromConsole = scanner.nextLine().replaceAll("\\s+", "")
                    .toCharArray();
            matrix2[row] = rowFromConsole;

        }
        char[][] matrix3 = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix3[row][col] = '*';
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix1[row][col] == matrix2[row][col]) {
                    matrix3[row][col] = matrix1[row][col];
                }
            }
        }
        printCharMatrix(matrix3);
    }


    public static void printCharMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}