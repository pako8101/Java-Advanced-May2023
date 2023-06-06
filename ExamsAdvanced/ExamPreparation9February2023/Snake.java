package ExamsAdvanced.ExamPreparation9February2023;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int snakeRow = -1, snakeCol = -1;
        int layerFirstRow = -1, layerSecondCol = -1,
                layerSecondRow = -1, layerFirstCol = -1;
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {

            matrix[row] = scanner.nextLine().toCharArray();

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                }
                if (matrix[row][col] == 'B') {
                    if (layerFirstRow == -1) {
                        layerFirstRow = row;
                        layerFirstCol = col;
                    } else {
                        layerSecondRow = row;
                        layerSecondCol = col;
                    }
                }
            }
        }

        int foodEaten = 0;
        boolean isSnakeWithinLimits = true;
        while (isSnakeWithinLimits && foodEaten < 10) {
            String command = scanner.nextLine();
            matrix[snakeRow][snakeCol] = '.';
            switch (command) {
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "up":
                    snakeRow--;
                    break;
            }
            if (snakeRow < 0 || snakeRow >= size || snakeCol < 0 || snakeCol >= size) {
                isSnakeWithinLimits = false;
                continue;
            }
            if (matrix[snakeRow][snakeCol] == '*') {
                foodEaten++;
            }
            if (snakeRow == layerFirstRow && snakeCol == layerFirstCol) {
                matrix[snakeRow][snakeCol] = '.';
                snakeRow = layerSecondRow;
                snakeCol = layerSecondCol;
            } else if (snakeRow == layerSecondRow && snakeCol == layerSecondCol) {
                matrix[snakeRow][snakeCol] = '.';
                snakeRow = layerFirstRow;
                snakeCol = layerFirstCol;
            }
            matrix[snakeRow][snakeCol] = 'S';
        }
        if (foodEaten == 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d%n", foodEaten);
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
