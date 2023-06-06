package ExamsAdvanced.JavaAdvancedExam26June2021;

import java.util.Scanner;

public class Python {
    public static int length;
    public static int countFood;
    public static boolean hasDead = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split("\\s+");
        String[][] matrix = new String[n][n];
        fillMatrix(matrix, scanner);
        int rowPython = 0;
        int colPython = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                String currentElement = matrix[row][col];
                if (currentElement.equals("s")) {
                    rowPython = row;
                    colPython = col;
                } else if (currentElement.equals("f")) {
                    countFood++;
                }
            }
        }
        for (String command : commands) {
            matrix[rowPython][colPython] = "*";
            switch (command) {
                case "left":
                    colPython--;
                    break;
                case "right":
                    colPython++;
                    break;
                case "up":
                    rowPython--;
                    break;
                case "down":
                    rowPython++;
                    break;
            }
            if (rowPython < 0 || rowPython >= n) {
                if (rowPython < 0) {
                    rowPython = n - 1;
                }
                if (rowPython >= n) {
                    rowPython = 0;
                }
            }
            if (colPython < 0 || colPython >= n) {
                if (colPython < 0) {
                    colPython = n - 1;
                }
                if (colPython >= n) {
                    colPython = 0;
                }

            }

            if (countFood == 0) {
                break;
            }
            if (matrix[rowPython][colPython].equals("f")) {
                length++;
                countFood--;
            } else if (matrix[rowPython][colPython].equals("e")) {
                hasDead = true;
                break;
            }
            matrix[rowPython][colPython] = "s";
        }
        if (countFood == 0) {
            System.out.printf("You win! Final python length is %d\n", length);
        } else if (countFood > 0 && hasDead) {
            System.out.printf("You lose! There is still %d food to be eaten.\n", countFood);
        } else {

            System.out.println("You lose! Killed by an enemy!");
        }
    }


    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");

        }

    }
}