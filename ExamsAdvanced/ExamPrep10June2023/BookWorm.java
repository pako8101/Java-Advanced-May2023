package ExamsAdvanced.ExamPrep10June2023;

import java.util.Scanner;

public class BookWorm {
    private static int warmRow=-1;
    private static int warmCol=-1;
    private static boolean isOutSide = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder builder = new StringBuilder(input);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);
        findWarmPosition(size,matrix);
        matrix[warmRow][warmCol] = "P";
        String command = scanner.nextLine();
        while (!command.equals("end")) {

            //запазвам къде съм бил
            int startRow = warmRow;//ред и колона от които тръгва
           int startCol = warmCol;
            switch (command) {
                case "up":
                    warmRow--;
                    if (warmRow < 0) {
                        warmRow++;
                        isOutSide = true;
                    }
                    break;
                case "down":
                    warmRow++;
                    if (warmRow >= size) {
                        warmRow--;
                        isOutSide = true;
                    }
                    break;
                case "left":
                    warmCol--;
                    if (warmCol < 0) {
                        warmCol++;
                        isOutSide = true;
                    }
                    break;
                case "right":
                    warmCol++;
                    if (warmCol >= size) {
                        warmCol--;
                        isOutSide = true;
                    }
                    break;
            }
            if (!isOutSide) {
                String currentText = matrix[warmRow][warmCol];
                if (!currentText.equals("-")) {
                    builder.append(currentText);
                }
                matrix[warmRow][warmCol] = "P";
                matrix[startRow][startCol] = "-";
            } else {
                if (builder.length()>0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            }

            command = scanner.nextLine();

        }
        System.out.println(builder.toString());
        printMatrix(matrix);
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }

    private static void findWarmPosition(int size, String[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String currentRow = matrix[row][col];
                if (currentRow.equals("P")) {
                    warmRow = row;
                    warmCol = col;
                    return;
                }
            }
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}