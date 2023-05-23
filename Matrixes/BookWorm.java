package Matrixes;

import java.util.Scanner;

public class BookWorm {
    private static int warmRow = -1;
    private static int warmCol = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder builder = new StringBuilder(input);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        findWarmPosition(size, matrix);
        matrix[warmRow][warmCol] = "P";
        String commands = scanner.nextLine();
        while (!commands.equals("end")) {

            switch (commands) {
                case "up":
                    warmRow--;
                    if (warmRow < 0) {
                        warmRow++;
                        builder.deleteCharAt(builder.length() - 1);
                    } else {
                        int addRow = warmRow + 1;
                        matrix[addRow][warmCol] = "-";
                        if (matrix[warmRow][warmCol].equals("-")) {
                            matrix[warmRow][warmCol] = "P";

                        } else {
                            String str = matrix[warmRow][warmCol];
                            builder.append(str);
                            matrix[warmRow][warmCol] = "P";
                        }
                    }
                    break;
                case "down":
                    warmRow++;
                    if (warmRow > matrix.length - 1) {
                        warmRow--;
                        builder.deleteCharAt(builder.length() - 1);
                    } else {
                        int addRow = warmRow - 1;
                        matrix[addRow][warmCol] = "-";
                        if (matrix[warmRow][warmCol].equals("-")) {
                            matrix[warmRow][warmCol] = "P";

                        } else {
                            String str = matrix[warmRow][warmCol];
                            builder.append(str);
                            matrix[warmRow][warmCol] = "P";
                        }
                    }
                    break;
                case "left":
                    warmCol--;
                    if (warmCol < 0) {
                        warmCol++;
                        builder.deleteCharAt(builder.length() - 1);
                    } else {
                        int addCol = warmCol + 1;
                        matrix[warmRow][addCol] = "-";
                        if (matrix[warmRow][warmCol].equals("-")) {
                            matrix[warmRow][warmCol] = "P";
                        } else {
                            String str = matrix[warmRow][warmCol];
                            builder.append(str);
                            matrix[warmRow][warmCol] = "P";
                        }
                    }
                    break;
                case "right":
                    warmCol++;
                    if (warmCol > matrix.length - 1) {
                        warmCol--;
                        builder.deleteCharAt(builder.length() - 1);
                    } else {
                        int addCol = warmCol - 1;
                        matrix[warmRow][addCol] = "-";
                        if (matrix[warmRow][warmCol].equals("-")) {
                            matrix[warmRow][warmCol] = "P";

                    } else {
                            String str = matrix[warmRow][warmCol];
                            builder.append(str);
                            matrix[warmRow][warmCol] = "P";
                        }
                    }
                    break;

            }
            commands = scanner.nextLine();
        }

        System.out.println(builder.toString().trim());
        printMatrix(matrix);
    }

    private static void findWarmPosition(int size, String[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String currentRow = matrix[row][col];
                if (currentRow.equals("P")) {
                    warmRow = row;
                    warmCol = col;
                }
            }
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
