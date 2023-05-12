package JavaAdvanced2023MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RallyRacing {
    public static int currentRow;
    public static int currentCol;
    public static int km;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();

        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);
        List<Integer> tunnelCoordinates = new ArrayList<>();
        findTunnel(matrix, tunnelCoordinates);
        String direction = scanner.nextLine();
        while (!direction.equals("End")) {

            switch (direction) {
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }
            String movedPlace = matrix[currentRow][currentCol];
            if (movedPlace.equals(".")) {
                km += 10;
            } else if (movedPlace.equals("F")) {
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                km += 10;
                break;
            } else if (movedPlace.equals("T")) {

                    currentRow = tunnelCoordinates.get(2);
                    currentCol = tunnelCoordinates.get(3);
                    km += 30;
                    matrix[tunnelCoordinates.get(0)][tunnelCoordinates.get(1)] = ".";
                    matrix[tunnelCoordinates.get(2)][tunnelCoordinates.get(3)] = ".";
                }



            direction = scanner.nextLine();
            if (direction.equals("End")){
                System.out.printf("Racing car %s DNF.%n", carNumber);
            }

        }
        System.out.printf("Distance covered %d km.%n", km);
        matrix[currentRow][currentCol] = "C";
        printMatrix(matrix);
    }

    private static void findTunnel(String[][] matrix, List<Integer> tunnelCoordinates) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                String currentElement = matrix[row][col];
                if (currentElement.equals("T")) {
                    tunnelCoordinates.add(row);
                    tunnelCoordinates.add(col);
                }

            }
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }

    }
}