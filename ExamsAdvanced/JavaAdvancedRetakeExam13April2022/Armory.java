package ExamsAdvanced.JavaAdvancedRetakeExam13April2022;

import java.util.Scanner;

public class Armory {
    private static int randomRow;
    private static int randomCol;
    private static boolean isOut = false;
    private static int buySword;
    private static int mirrorRow;
    private static int mirrorCol;
    private static boolean hasDeal = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] armory = new String[size][size];
        fillMatrix(armory, scanner);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String currentRow = armory[row][col];
                if (currentRow.equals("A")) {
                    randomRow = row;
                    randomCol = col;
                    break;
                }
            }
        }

        while (true) {
            String command = scanner.nextLine();
            armory[randomRow][randomCol] = "-";
            randomRow = mirrorRow;
            randomCol = mirrorCol;
            switch (command) {
                case "up":
                    mirrorRow--;
                    break;
                case "down":
                    mirrorRow++;
                    break;
                case "left":
                    mirrorCol--;
                    break;
                case "right":
                    mirrorCol++;
                    break;
            }
            if (isOutOfBounds(armory, mirrorRow, mirrorCol)) {
                isOut = true;
                break;
            }
            String currentPosition = armory[mirrorRow][mirrorCol];

            if (Character.isDigit(currentPosition.charAt(0))) {
                buySword += Character.getNumericValue(currentPosition.charAt(0));
                armory[mirrorRow][mirrorCol] = "-";

            } else if (currentPosition.equals("M")) {
                armory[mirrorRow][mirrorCol] = "-";
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        String currentRow = armory[row][col];
                        if (currentRow.equals("M") && (row != mirrorRow || col != mirrorCol)) {
                            armory[row][col] = "-";
                            mirrorRow = row;
                            mirrorCol = col;
                        }

                    }
                }
            }
            armory[mirrorRow][mirrorCol] = "A";
            randomRow = mirrorRow;
            randomCol = mirrorCol;

            if (buySword >= 65) {
                hasDeal = true;
                break;
            }
        }
        if (isOut) {
            System.out.println("I do not need more swords!");

        } else if (hasDeal){
            System.out.println( "Very nice swords, I will come back for more!");
           // System.out.printf(hasDeal ? "Very nice swords, I will come back for more!%n" : "I do not need more swords!%n");
        }else {
            System.out.println("I do not need more swords!");
        }
            System.out.printf("The king paid %d gold coins.\n", buySword);
            printMatrix(armory);
           // scanner.close();

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
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

    private static boolean isOutOfBounds(String[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    private static void findMirrorPosition(int size, String[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String currentRow = matrix[row][col];
                if (currentRow.equals("M") && (row != randomRow || col != randomCol)) {
                    matrix[row][col] = "-";
                    mirrorRow = row;
                    mirrorCol = col;
                    return;
                }
            }
        }
    }
}