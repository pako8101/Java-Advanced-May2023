package ExamsAdvanced.JavaAdvancedRetakeExam17Dec2019;

import java.util.Scanner;

public class PresentDelivery {
    private static int santaRow;
    private static int santaCol;
    private static int countNiceKids;
    private static boolean isRunOutPresent = false;
private static int happyKids;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int presentsCount = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        String[][] neighborhood = new String[size][size];
        fillMatrix(neighborhood, scanner);
        // findSantaPosition(size, neighborhood);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String currentRow = neighborhood[row][col];
                if (currentRow.equals("S")) {
                    santaRow = row;
                    santaCol = col;
                }
                if (currentRow.equals("V")) {
                    countNiceKids++;
                }
            }
            String commands = scanner.nextLine();
            while (!commands.equals("Christmas morning")) {
                commands = scanner.nextLine();
                int startRow = santaRow;//ред и колона от които тръгва
                int startCol = santaCol;
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
                if (isOutOfBounds(size)) continue;

                if (neighborhood[santaRow][santaCol].equals("V")) {
                    presentsCount--;
happyKids++;

                } else if (neighborhood[santaRow][santaCol].equals("X")) {

                    continue;
                }
                if (neighborhood[santaRow][santaCol].equals("C")) {
                    if (neighborhood[santaRow + 1][santaCol].equals("V") ||
                            neighborhood[santaRow + 1][santaCol].equals("X")) {
                        presentsCount--;
                        happyKids++;
                    }
                    if (neighborhood[santaRow - 1][santaCol].equals("V") ||
                            neighborhood[santaRow - 1][santaCol].equals("X")) {
                        presentsCount--;
                        happyKids++;
                    }
                    if (neighborhood[santaRow][santaCol - 1].equals("V") ||
                            neighborhood[santaRow][santaCol - 1].equals("X")) {
                        presentsCount--;
                        happyKids++;
                    }
                    if (neighborhood[santaRow][santaCol + 1].equals("V") ||
                            neighborhood[santaRow][santaCol + 1].equals("X")) {
                        presentsCount--;
                        happyKids++;
                    }

                }
                neighborhood[santaRow][santaCol] = "-";
                neighborhood[santaRow][santaCol] = "S";

                if (presentsCount == 0) {
                    isRunOutPresent = true;
                    break;
                }
                commands = scanner.nextLine();
                printMatrix(neighborhood);
        }

            if (isRunOutPresent) {
                System.out.println("Santa ran out of presents.");
            }

            if (countNiceKids != 0) {
                System.out.printf("No presents for %d nice kid/s.\n", countNiceKids);

            } else {
                System.out.printf("Good job, Santa! %d happy nice kid/s.\n", happyKids);
            }
        }
    }
    private static boolean isOutOfBounds(int size) {
        if (santaRow < 0 || santaRow >= size || santaCol < 0 || santaCol >= size) {
            return true;
        }
        return false;
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

                }if (currentRow.equals("V")){
                    countNiceKids++;
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