package ExamsAdvanced.JavaAdvancedRetakeExam12April2023;

import java.util.Scanner;

public class TheSquirrel {
    private static int countHazelnuts = 0;
    private static int squirrelRow = -1;
    private static int squirrelCol = -1;
    private static char currentSquirrelPosition;
    private static boolean isOutOfField = false;
    private static boolean trapEncountered = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String[] commands = input.split(", ");

        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String rowFromConsole = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = rowFromConsole.charAt(col);
                ;
            }

        }
        findSquirrelPosition(size, matrix);

        for (String direction : commands) {
            currentSquirrelPosition = matrix[squirrelRow][squirrelCol];
            matrix[squirrelRow][squirrelCol] = '*';
            if ("left".equals(direction)) {
                if (squirrelCol - 1 >= 0) {
                    squirrelCol--;
                } else {
                    isOutOfField = true;
                    break;
                }
            } else if ("right".equals(direction)) {
                if (squirrelCol + 1 < size) {
                    squirrelCol++;
                } else {
                    isOutOfField = true;
                    break;
                }
            } else if ("up".equals(direction)) {
                if (squirrelRow - 1 >= 0) {
                    squirrelRow--;
                } else {
                    isOutOfField = true;
                    break;
                }
            } else if ("down".equals(direction)) {
                if (squirrelRow + 1 < size) {
                    squirrelRow++;
                } else {
                    isOutOfField = true;

                    break;
                }
            }
            currentSquirrelPosition = matrix[squirrelRow][squirrelCol];


            if (currentSquirrelPosition == 'h') {
                countHazelnuts++;
                matrix[squirrelRow][squirrelCol] = '*';
            } else if (currentSquirrelPosition == 't') {
                trapEncountered = true;
                break;
            }
            currentSquirrelPosition = matrix[squirrelRow][squirrelCol];
        }
        if (isOutOfField) {
            System.out.println("The squirrel is out of the field.");
        } else if (trapEncountered) {
            System.out.println("Unfortunately, the squirrel stepped on a trap...");
        }
        else if (countHazelnuts < 3) {
            System.out.println("There are more hazelnuts to collect.");
        } else {
            System.out.println("Good job! You have collected all hazelnuts!");
        }
        System.out.printf("Hazelnuts collected: %d%n", countHazelnuts);
    }


    private static void findSquirrelPosition(int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char currentRow = matrix[row][col];
                if (currentRow == 's') {
                    squirrelRow = row;
                    squirrelCol = col;
                    return;
                }
            }
        }
    }

    public static void printCharMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }

    }
}
