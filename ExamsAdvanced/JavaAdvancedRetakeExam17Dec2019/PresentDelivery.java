package ExamsAdvanced.JavaAdvancedRetakeExam17Dec2019;

import java.util.Scanner;

public class PresentDelivery {
    private static int santaRow;
    private static int santaCol;
    private static int countNiceKids;
    private static boolean isRunOutPresent = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int presentsCount = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        String[][] neighborhood = new String[size][size];
        fillMatrix(neighborhood, scanner);
        findSantaPosition(size, neighborhood);
        String commands = scanner.nextLine();
        while (!commands.equals("Christmas morning") && presentsCount > 0) {
            commands = scanner.nextLine();
            switch (commands) {
                case "up":
                    santaRow--;
                    break;
                case "down":
                    santaRow++;
                    break;
                case "left":
                    santaCol--;
                    break;
                case "right":
                    santaCol++;
                    break;
            }
            if (santaRow < 0 || santaRow >= size || santaCol < 0 || santaCol >= size) {
                continue;
            }
            String currentPosition = neighborhood[santaRow][santaCol];
            if (currentPosition.equals("V")) {
                countNiceKids++;
                presentsCount--;
                neighborhood[santaRow][santaCol] = "-";
            } else if (currentPosition.equals("X")) {
                neighborhood[santaRow][santaCol] = "-";
                continue;

            }
            if (currentPosition.equals("C")) {
                presentsCount -= 4;
                neighborhood[santaRow][santaCol] = "-";
            }
            if (presentsCount == 0) {
                isRunOutPresent = true;
                break;
            }

            neighborhood[santaRow][santaCol] = "-";
            commands = scanner.nextLine();

        }


        if (isRunOutPresent) {
            System.out.println("Santa ran out of presents.");
        }
        printMatrix(neighborhood);
        if (countNiceKids <= presentsCount) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.\n", countNiceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.\n", Math.abs(presentsCount - countNiceKids));
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void findSantaPosition(int size, String[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String currentRow = matrix[row][col];
                if (currentRow.equals("S")) {
                    santaRow = row;
                    santaCol = col;
                    break;
                }
            }
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}