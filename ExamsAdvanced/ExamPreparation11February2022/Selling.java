package ExamsAdvanced.ExamPreparation11February2022;

import java.util.Scanner;

public class Selling {
    static int currentRow;
    static int currentCol;
    static int money;
    static boolean isOutOfBounds = false;
    static boolean isEnoughMoney = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "")
                    .toCharArray();
            for (int col = 0; col < n; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 'S') {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }
        while (true) {
            String command = scanner.nextLine();
            matrix[currentRow][currentCol] = '-';
            switch (command) {
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
            if (currentRow < 0 || currentRow >= matrix.length || currentCol < 0 || currentCol >= matrix.length) {
                isOutOfBounds = true;
                break;
            }
            char current = matrix[currentRow][currentCol];
            if (current == 'O') {
                matrix[currentRow][currentCol] = '-';
                break;
            } else if (Character.isDigit(current)) {
                money += Character.getNumericValue(current);
            }

            if (money >= 50) {
                isEnoughMoney = true;
                break;
            }
            matrix[currentRow][currentCol] = 'S';
        }
            if (isOutOfBounds) {
                System.out.println("Bad news, you are out of the bakery.");

            } else if (isEnoughMoney) {
                System.out.println("Good news! You succeeded in collecting enough money!");

            }
            System.out.printf("Money: %d%n", money);
            printCharMatrix(matrix);
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

