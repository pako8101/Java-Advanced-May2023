package JavaAdvanced2023MultidimensionalArrays.Lab;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrCount = scanner.nextInt();
        int sizeArr = scanner.nextInt();
        int[][] firstMatrix = new int[arrCount][sizeArr];

        for (int r = 0; r < arrCount; r++) {
            for (int c = 0; c < sizeArr; c++) {
                firstMatrix[r][c] = scanner.nextInt();
            }
        }
        arrCount = scanner.nextInt();
        sizeArr = scanner.nextInt();
        int[][] secondMatrix = new int[arrCount][sizeArr];
        for (int r = 0; r < secondMatrix.length; r++) {
            for (int c = 0; c < secondMatrix[r].length; c++) {
                secondMatrix[r][c] = scanner.nextInt();
            }

        }
        boolean areEqual = firstMatrix.length == secondMatrix.length
                && areEqualMatrix(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

//        for (int i = 0; i < arrCount; i++) {
//            int [] arr = Arrays. stream(scanner.nextLine().split(" "))
//                            .mapToInt(Integer::parseInt)
//                            .toArray();
//            first[i] = arr;


    private static boolean areEqualMatrix(int[][] firstMatrix, int[][] secondMatrix) {
if ( firstMatrix.length != secondMatrix.length){
    return false;
}
        for (int r = 0; r < firstMatrix.length; r++) {

            int[] first = firstMatrix[r];
            int[] second = secondMatrix[r];
            if (first.length != second.length) {
                return false;
            }
            for (int i = 0; i < first.length; i++) {
                int firstNum = first[i];
                int secondNum = second[i];
                if (firstNum != secondNum) {
                    return false;

                }
            }
        }
        return true;
    }

    public static void printMatrix(int[][] firstMatrix) {
        for (int[] arr : firstMatrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}

