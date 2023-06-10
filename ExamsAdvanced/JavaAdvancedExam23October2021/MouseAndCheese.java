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
            // String direction = scanner.nextLine();
            matrix[mouseRow][mouseCol] = '-';
            switch (command) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;

                    break;
            }
            if (mouseCol >= size || mouseCol < 0 || mouseRow >= size || mouseRow < 0) {
                System.out.println("Where is the mouse?");
                break;
            }
            if (matrix[mouseRow][mouseCol] == 'c') {
                cheese++;

            } else if (matrix[mouseRow][mouseCol] == 'B') {
                continue;
            }
            matrix[mouseRow][mouseCol] = 'M';

            command = scanner.nextLine();
        }
        if (cheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - cheese);
        }
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
