package ExamsAdvanced.JavaAdvancedRetakeExam13April2022;

import java.util.Scanner;

public class Armory {
    private static int randomRow;
    private static int randomCol;
    private static int blades;
    private static int buySword;
    private static int mirrorRow;
    private static int mirrorCol;
    private static boolean hasDeal=false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] armory = new String[size][size];
        fillMatrix(armory, scanner);
        findRandomPosition(size, armory);
        String command;
        while (buySword < 65) {
            command = scanner.nextLine();
            switch (command) {
                case "up":
                    randomRow--;
                    break;
                case "down":
                    randomRow++;
                    break;
                case "left":
                    randomCol--;
                    break;
                case "right":
                    randomCol++;
                    break;
            }
            if (!isInBounds(armory, randomRow, randomCol)) {
                System.out.println("I do not need more swords!");
                break;
            }
            String currentPosition = armory[randomRow][randomCol];

            if (Character.isDigit(currentPosition.charAt(0))) {
                buySword += Integer.parseInt(currentPosition);
                armory[randomRow][randomCol] = "-";
            } else if (currentPosition.equals("M")) {
                findMirrorPosition(size, armory);
                mirrorRow = randomRow;
                mirrorCol = randomCol;
                armory[randomRow][randomCol] = "-";
                armory[randomRow][randomCol] = "A";
            }
            if (buySword >= 65) {
                hasDeal=true;

                break;
            }
        }
        System.out.printf(hasDeal ? "Very nice swords, I will come back for more!":"I do not need more swords!");
        System.out.printf("The king paid %d gold coins.\n", buySword);
        printMatrix(armory);
        scanner.close();


    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }

    private static void findRandomPosition(int size, String[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String currentRow = matrix[row][col];
                if (currentRow.equals("A")) {
                    randomRow = row;
                    randomCol = col;
                    return;
                }
            }
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

    private static boolean isInBounds(String[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void findMirrorPosition(int size, String[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String currentRow = matrix[row][col];
                if (currentRow.equals("M") && (row != randomRow || col != randomCol)) {
                    mirrorRow = row;
                    mirrorCol = col;
                    break;
                }
            }
        }
    }
}