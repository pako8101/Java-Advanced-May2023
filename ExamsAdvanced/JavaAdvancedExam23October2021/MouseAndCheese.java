package ExamsAdvanced.JavaAdvancedExam23October2021;

import java.util.Scanner;

public class MouseAndCheese {
    private static int mouseRow;
    private static int mouseCol;
    private static int cheese;
    private static int cheeseLeft;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            char[] rowFromConsole = scanner.nextLine()
                    .toCharArray();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = rowFromConsole[col];
                if (matrix[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;

                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String direction = scanner.nextLine();
            matrix[mouseRow][mouseCol] = '-';
            switch (direction) {
                case "up":
                    if (mouseRow - 1 > 0) {
                        System.out.println("Where is the mouse?");
                        return;
                    } else {
                        if (matrix[mouseRow][mouseCol] == 'c') {
                            cheese++;
                            matrix[mouseRow][mouseCol] = '-';
                        }
                        mouseRow--;
                    }
                    break;
                case "down":
                    if (mouseRow + 1 >= size) {
                        System.out.println("Where is the mouse?");
                        return;
                    } else {
                        if (matrix[mouseRow][mouseCol] == 'c') {
                            cheese++;
                            matrix[mouseRow][mouseCol] = '-';
                        }
                        mouseRow++;
                    }
                    break;
                case "left":
                    if (mouseCol - 1 > 0) {
                        System.out.println("Where is the mouse?");
                        return;
                    } else {
                        mouseCol--;
                        if (matrix[mouseRow][mouseCol] == 'c') {
                            cheese++;
                            matrix[mouseRow][mouseCol] = '-';
                        }
                    }
                    break;
                case "right":
                    if (mouseCol + 1 >= size) {
                        System.out.println("Where is the mouse?");
                        return;
                    } else {
                        mouseCol++;
                        if (matrix[mouseRow][mouseCol] == 'c') {
                            cheese++;
                            matrix[mouseRow][mouseCol] = '-';
                        }
                    }
                    break;

            }
            if (matrix[mouseRow][mouseCol] == 'c') {
                cheeseLeft++;
            } else if (matrix[mouseRow][mouseCol] == 'B') {
                matrix[mouseRow][mouseCol] = '-';
                continue;
            }

            command = scanner.nextLine();
            if (cheeseLeft == 0) {
                System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheese);
            } else {
                System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", cheeseLeft);
            }
            printCharMatrix(matrix);
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
