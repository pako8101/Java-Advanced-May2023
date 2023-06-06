package ExamsAdvanced.JavaAdvancedExam20February2021;

import java.util.Scanner;

public class Bomb {
    static int rowBomb = -1;
    static int colBomb = -1;
    static int countBomb;
    static int bombFound;
    static String currentRow;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = new String[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {

              currentRow  = matrix[row][col];
                if (currentRow.equals("B")) {
                    countBomb++;
                } else if (currentRow.equals("s")) {
                    rowBomb = row;
                    colBomb = col;
                }
            }
        }
        for (String command : commands) {
//            matrix[rowBomb][colBomb] = "+";
            switch (command) {
                case "left":
                    if (colBomb > 0) {
                        colBomb--;
                    }

                    break;
                case "right":
                    if (colBomb < matrix.length - 1) {
                        colBomb++;
                    }
                    break;
                case "up":
                    if (rowBomb > 0) {
                        rowBomb--;
                    }

                    break;
                case "down":
                    if (rowBomb < matrix.length - 1) {
                        rowBomb++;
                    }

                    break;
            }
            String current = matrix[rowBomb][colBomb];
            if (current.equals("B")) {
                countBomb--;
                bombFound++;

                System.out.println("You found a bomb!");
                matrix[rowBomb][colBomb] = "+";
                if (countBomb == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (current.equals("e")) {
                System.out.println("END! " + countBomb + " bombs left on the field");
                return;
            }

        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", countBomb, rowBomb, colBomb);

    }
}
