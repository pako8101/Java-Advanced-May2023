package JavaAdvanced2023MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        String[] dimension = scanner.nextLine().split(", ");

        int arrCount =Integer.parseInt(dimension[0]) ;
        String pattern = dimension[1];

        int[][] matrix = new int[arrCount][arrCount];
        if (pattern.equals("A")){
            fillMatrixPatternA(counter, arrCount, matrix);
        }
        else {
            fillMatrixPatternB(counter, arrCount, matrix);
        }
        for (int r = 0; r < arrCount; r++) {
            for (int c = 0; c < arrCount; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternB(int counter, int arrCount, int[][] matrix) {
        for (int c = 0; c < arrCount; c++) {
            if (c % 2 == 0){
                for (int r = 0; r < arrCount; r++) {
                    matrix[r][c] = counter;
                    counter++;
                }
            }else {
                for (int r = arrCount -1; r >= 0 ; r--) {
                    matrix[r][c] = counter;
                    counter++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int counter, int arrCount, int[][] matrix) {
        for (int c = 0; c < arrCount; c++) {
            for (int r = 0; r < arrCount; r++) {
                matrix[r][c] = counter;
                counter++;
            }

        }
    }

}


