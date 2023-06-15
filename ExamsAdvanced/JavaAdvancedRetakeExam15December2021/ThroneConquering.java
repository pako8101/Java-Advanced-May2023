package ExamsAdvanced.JavaAdvancedRetakeExam15December2021;

import java.util.Scanner;

public class ThroneConquering {
    private static int parisRow = -1;
    private static int parisCol = -1;
    private static int energy = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            field[row] = scanner.nextLine().toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < field[row].length; col++) {
                char currentPosition = field[row][col];
                if (currentPosition == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }
        while (energy > 0) {
            String command = scanner.nextLine();
            String direction = command.split(" ")[0];
            int enemyRow = Integer.parseInt(command.split(" ")[1]);
            int enemyCol = Integer.parseInt(command.split(" ")[2]);
            field[parisRow][parisCol] = '-';
            field[enemyRow][enemyCol] = 'S';
            switch (direction) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < field.length) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if (parisCol + 1 < field.length) {
                        parisCol++;
                    }
                    break;
            }
            energy--;
            if (energy <= 0) {
                isParisDead(field, parisRow, parisCol);
            }
            if (field[parisRow][parisCol] == 'S') {
                energy -= 2;
                field[parisRow][parisCol] = '-';
                if (energy <= 0) {
                    isParisDead(field, parisRow, parisCol);
                    break;
                }
            } else if (field[parisRow][parisCol] == 'H') {
                field[parisRow][parisCol] = '-';
                System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
                printCharMatrix(field);
                break;
            }
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

    public static void isParisDead(char[][] field, int parisRow, int parisCol) {
        if (energy <= 0) {
            field[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
            printCharMatrix(field);
        }
    }
}
