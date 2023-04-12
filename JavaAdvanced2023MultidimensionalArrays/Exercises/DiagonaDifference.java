package JavaAdvanced2023MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class DiagonaDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] rowInput = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(rowInput[col]);
            }
        }
        int mainDiagonal = 0;
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                if (row==col){
//                    mainDiagonal += matrix[row][col];
        for (int index = 0; index < size; index++) {
            mainDiagonal += matrix[index][index];
        }
        int secondDiagonal = 0;
//        for (int row = size - 1, col = 0; col < size && row >= 0; row--, col++) {
//            secondDiagonal += matrix[row][col];
        for (int row = 0; row < size; row++) {
            secondDiagonal += matrix[row][size - row - 1];
        }
        System.out.println(Math.abs(mainDiagonal - secondDiagonal));
    }
}


