package ExamsAdvanced.ExamPrepAdvancedMartin;

import java.util.Scanner;

public class ReVoltRebuild {

        public static int playerCol;
        public static int playerRow;
        public static boolean hasWon = false;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int size = Integer.parseInt(scanner.nextLine());
            int countCommands = Integer.parseInt(scanner.nextLine());
            char[][] matrix = new char[size][size];
            for (int row = 0; row < size; row++) {
                String matrixRow = scanner.nextLine();
                matrix[row] = matrixRow.toCharArray();

                if (matrixRow.contains("f")) {
                    playerRow = row;
                    playerCol = matrixRow.indexOf("f");
                }
            }
            while (countCommands-- > 0 && !hasWon) {
                String command = scanner.nextLine();

                if (command.equals("up")) {
                    movePlayer(matrix, -1, 0);
                } else if (command.equals("down")) {
                    movePlayer(matrix, 1, 0);
                } else if (command.equals("left")) {
                    movePlayer(matrix, 0, -1);
                } else if (command.equals("right")) {
                    movePlayer(matrix, 0, 1);
                }

            }
            System.out.println(hasWon ? "Player won!" : "Player lost!");
            printCharMatrix(matrix);
        }


        private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {
            int nextRow = playerRow + rowMutator;
            int nextCol = playerCol + colMutator;
            if (isOutOfBounds(matrix, nextRow, nextCol)) {
                if (nextRow < 0 || nextRow >= matrix.length) {
                    nextRow = nextRow < 0 ? matrix.length - 1 : 0;
                } else {
                    nextCol = nextCol < 0 ? matrix[nextRow].length - 1 : 0;
                }

            }
            if (matrix[nextRow][nextCol] == 'T') {
                return;
            } else if (matrix[nextRow][nextCol] == 'B') {
                matrix[playerRow][playerCol] = '-';
                playerRow = nextRow;
                playerCol = nextCol;
                movePlayer(matrix,rowMutator,colMutator);

            } else if (matrix[nextRow][nextCol] == 'F') {
                hasWon = true;
            }
            if (matrix[playerRow][playerCol]!= 'B'){
                matrix[playerRow][playerCol] = '-';
            }

            matrix[nextRow][nextCol] = 'f';
            playerRow = nextRow;
            playerCol = nextCol;
        }



        public static void printCharMatrix(char[][] matrix) {
            for (char[] row : matrix) {
                for (char element : row) {
                    System.out.print(element);
                }
                System.out.println();
            }
        }

        private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
            return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;

        }
    }
