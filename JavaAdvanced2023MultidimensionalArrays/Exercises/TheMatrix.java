package JavaAdvanced2023MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimension = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        int[][] matrix = new int[rows][cols];
        readMAtrixWithStreamAPI(scanner,rows,matrix);
       readMAtrixWithForLoop(scanner,rows,cols,matrix);
        printMAtrixWithForEach(matrix);
        printMAtrixWithForLoop(rows,cols,matrix);
        System.out.println();
        }

    private static void printMAtrixWithForLoop(int rows, int cols,int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void printMAtrixWithForEach(int[][] matrix) {
        for (int[] row:matrix) {
            for (int element:row) {
                System.out.println(element + " ");
            }
            System.out.println();
        }
    }

    private static void readMAtrixWithForLoop(Scanner scanner, int rows, int cols, int[][] matrix) {
            for (int row = 0; row < rows; row++) {
                String [] inputRow = scanner.nextLine().split(" ");
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] =Integer.parseInt(inputRow[col]) ;
                }
            }
    }

    private static void readMAtrixWithStreamAPI(Scanner scanner, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            int[]rowFromConsole = Arrays.stream(scanner.nextLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row]= rowFromConsole;
        }
    }
}

