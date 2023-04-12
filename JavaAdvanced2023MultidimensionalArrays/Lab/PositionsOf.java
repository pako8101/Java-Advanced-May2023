package JavaAdvanced2023MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimension = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int arrCount = dimension[0];
        int sizeArr = dimension[1];

        int[][] matrix = new int[arrCount][sizeArr];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
//        for (int r = 0; r < arrCount; r++) {
//            for (int c = 0; c < sizeArr; c++) {
//                matrix[r][c] = scanner.nextInt();
        //  }

        int searchNum = scanner.nextInt();
        boolean isFoundAtLeastOnce = false;
//        StringBuilder output = new StringBuilder();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currentNum = matrix[r][c];
                if (currentNum == searchNum) {
                        System.out.println(r + " " +c);
                        isFoundAtLeastOnce = true;
//                    output.append(r)
//                            .append(" ")
//                            .append(c)
//                            .append(System.lineSeparator());
                }
            }
        }
            if (!isFoundAtLeastOnce){
//        System.out.println(output.isEmpty() ? " not found" : output);
//        if (output.isEmpty()){
                System.out.println("not found");
//            }else {
//            System.out.println(output);
        }
    }
}
