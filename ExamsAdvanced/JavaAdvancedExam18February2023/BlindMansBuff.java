package ExamsAdvanced.JavaAdvancedExam18February2023;

import java.util.Scanner;

public class BlindMansBuff {
    private static int currentRow;
    private static int currentCol;
    private static String currentPosition;
    private static int touchedOpponents;
    private static int moves;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] playground = new String[rows][cols];
        fillMatrix(playground, scanner);
        findCurrentPosition(rows, cols, playground);

        String command;
        while (!(command = scanner.nextLine()).equals("Finish") && touchedOpponents < 3) {
            playground[currentRow][currentCol] = "-";
            switch (command) {
                case "up":
                    if (currentRow - 1 >= 0) {
                        currentRow--;
                    } else {
                        continue;
                    }
                    break;
                case "down":
                    if (currentRow + 1 < playground.length) {
                        currentRow++;
                    } else {
                        continue;
                    }
                    break;
                case "left":
                    if (currentCol - 1 >= 0) {
                        currentCol--;
                    } else {
                        continue;
                    }
                    break;
                case "right":
                    if (currentCol + 1 < playground[currentRow].length) {
                        currentCol++;
                    } else {
                        continue;
                    }
                    break;
            }

            currentPosition = playground[currentRow][currentCol];
            if (currentPosition.equals("O")) {
                continue;
            } else if (currentPosition.equals("P")) {
                touchedOpponents++;
                playground[currentRow][currentCol] = "-";

        }
        moves++;
       // playground[currentRow][currentCol] = "B";

    }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedOpponents, moves);
        scanner.close();
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void findCurrentPosition(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String newRow = matrix[row][col];
                if (newRow.equals("B")) {
                    currentRow = row;
                    currentCol = col;
                    return;
                }
            }

        }
    }
}