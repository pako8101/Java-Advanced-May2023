package ExamsAdvanced.JavaAdvancedRetakeExam18August2021;

import java.util.Scanner;

public class FormulaOne {
    private static int playerPossRow = -1;
    private static int playerPossCol = -1;
    private static boolean hasWon = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[size][size];
        fillMatrix(field, scanner);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String currentRow = field[row][col];
                if (currentRow.equals("P")) {
                    playerPossRow = row;
                    playerPossCol = col;
                    break;
                }
            }
        }

        while (countCommands-- > 0) {
            String command = scanner.nextLine();
            int newRow = 0;
            int newCol = 0;
            switch (command) {
                case "up":
                    newRow = checkIsOut(playerPossRow - 1, size);
                    newCol = checkIsOut(playerPossCol, size);
                    if (field[newRow][newCol].equals("B")) {
                        newCol = checkIsOut(playerPossCol,size);
                        newRow = checkIsOut(playerPossRow - 2, size);
                    }
                    break;
                case "down":
                    newRow = checkIsOut(playerPossRow + 1, size);
                    newCol = checkIsOut(playerPossCol, size);
                    if (field[newRow][newCol].equals("B")) {
                        newRow = checkIsOut(playerPossRow + 2, size);
                        newCol = checkIsOut(playerPossCol,size);
                    }
                    break;
                case "left":
                    newCol = checkIsOut(playerPossCol - 1, size);
                    newRow = checkIsOut(playerPossRow, size);
                    if (field[newRow][newCol].equals("B")) {
                        newCol = checkIsOut(playerPossCol - 2, size);
                        newRow = checkIsOut(playerPossRow,size);
                    }
                    break;
                case "right":
                    newCol = checkIsOut(playerPossCol + 1, size);
                    newRow = checkIsOut(playerPossRow, size);
                    if (field[newRow][newCol].equals("B")) {
                        newCol = checkIsOut(playerPossCol + 2, size);
                        newRow = checkIsOut(playerPossRow,size);
                    }
                    break;

            }
            if (field[newRow][newCol].equals("T")) {
                continue;
//                newCol = playerPossCol;
//                newRow = playerPossRow;


            } else if (field[playerPossRow][playerPossCol].equals("F")) {
                hasWon = true;
                break;
            }
            field[playerPossRow][playerPossCol] = ".";
            field[newRow][newCol] = "P";
            playerPossRow = newRow;
            playerPossCol = newCol;
        }

        if (hasWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(field);
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }

    private static int checkIsOut(int value, int size) {
        if (value < 0) {
            value = size - 1;
        } else if (value >= size) {
            value = 0;
        }
        return value;
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
