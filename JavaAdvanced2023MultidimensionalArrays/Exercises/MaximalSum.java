package JavaAdvanced2023MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixSize = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] inputRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(inputRow[col]);
            }
        }
        int maxSUm = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
//                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
//                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
//                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                int sum = 0;
                for (int currentRow = row; currentRow < row + 3; currentRow++) {
                    for (int currentCol = col; currentCol < col + 3; currentCol++) {

                        sum += matrix[currentRow][currentCol];
                    }
                }
                if (sum > maxSUm) {
                    maxSUm = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSUm);
        for (int row = bestRow; row < bestRow + 3; row++) {
            for (int col = bestCol; col < bestCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
