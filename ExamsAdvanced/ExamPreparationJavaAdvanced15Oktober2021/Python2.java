package ExamsAdvanced.ExamPreparationJavaAdvanced15Oktober2021;

import java.util.Scanner;

public class Python2 {
    static int food = 0;
    static int prow = 0;
    static int pcol = 0;
    static int length = 1;
    static boolean isKilled = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row]  = scanner.nextLine().replaceAll("\\s+","")
                        .toCharArray();
                if (matrix[row][col] == 's') {
                    prow = row;
                    pcol = col;
                } else if (matrix[row][col] == 'f') {
                    food++;
                }
            }
        }
        for (String command : commands) {
            switch (command) {
                case "left":
                    movePython(matrix, prow, pcol - 1);
                    break;
                case "right":
                    movePython(matrix, prow, pcol + 1);
                    break;
                case "up":
                    movePython(matrix, prow - 1, pcol);
                    break;
                case "down":
                    movePython(matrix, prow + 1, pcol);
                    break;

            }
            if (length == -1 || food == 0) {
                break;
            }


        }
        if (food == 0) {
            System.out.println("You win! Final python length is " + length);
        } else if (food > 0 && length != -1) {
            System.out.println("You lose! There is still " + food + " food to be eaten.");
        } else {
            System.out.println("You lose! Killed by an enemy!");

        }

    }

    private static void movePython(char[][] matrix, int newRow, int newCol) {

        if (isOutOfBounds(matrix, newRow, newCol)) {
            int[] newIndexes = flipSnake(matrix.length, newRow, newCol);
            newRow = newIndexes[0];
            newCol = newIndexes[1];
        }
        if (matrix[newRow][newCol] == 'e') {
            length = -1;

        } else if (matrix[newRow][newCol] == 'f') {
            length++;
            food--;

        }
        prow = newRow;
        pcol = newCol;
    }

    private static int[] flipSnake(int length, int row, int col) {
        int[] result = new int[2];
        if (row < 0) {
            result[0] = length - 1;
            result[1] = col;
        } else if (row >= length) {
            result[1] = col;
        } else if (col < 0) {
            result[0] = row;
            result[1] = length - 1;
        } else {
            result[0] = row;
        }
        return result;
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r > matrix.length || c < 0 || c > matrix[r].length;
    }

}
