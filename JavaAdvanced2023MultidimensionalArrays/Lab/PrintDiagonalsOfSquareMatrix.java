package JavaAdvanced2023MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine()) ;

        int[][] matrix = new int[size][size];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
//        for (int i = 0; i < matrix.length; i++) {
//            System.out.print(matrix[i][i] + " ");
        int row=0;
        int cal = 0;
        while (row< matrix.length && cal< matrix[row].length){
            System.out.print(matrix[row][cal] + " ");
            row++;
            cal++;
        }
        System.out.println();
        row = matrix.length-1;
        cal= 0;
        while (row>=0&&cal< matrix[row].length){
            System.out.print(matrix[row][cal] + " ");
            row--;
            cal++;
        }
    }

}
