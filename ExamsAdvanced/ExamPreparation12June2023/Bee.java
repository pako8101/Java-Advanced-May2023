package ExamsAdvanced.ExamPreparation12June2023;

import java.util.Scanner;

public class Bee {
    private static int beeRow;
    private static int beeCol;
    private static int pollinatedFlowers;
    private static int bonus;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[][] beeTerritory = new String[size][size];
        for (int row = 0; row < size; row++) {
            beeTerritory[row] = scanner.nextLine().split("");
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String currentPosition = beeTerritory[row][col];
                if (currentPosition.equals("B")) {
                    beeRow = row;
                    beeCol = col;

                }

            }
            String command = scanner.nextLine();
            while (!command.equals("End")) {

                switch (command) {
                    case "up":
                        beeRow--;
                        break;
                    case "down":
                        beeRow++;
                        break;
                    case "left":
                        beeCol--;
                        break;
                    case "right":
                        beeCol++;
                        break;
                }
                if (!isInBounds(beeTerritory, beeRow, beeCol)) {
                    System.out.println("The bee got lost!");
                    break;
                }

                if (beeTerritory[beeRow][beeCol].equals("f")) {
                    pollinatedFlowers++;
                    beeTerritory[beeRow][beeCol] = ".";
                } else if (beeTerritory[beeRow][beeCol].equals("O")) {
                    beeTerritory[beeRow][beeCol] = ".";
                    continue;
                }
                beeTerritory[beeRow][beeCol] = "B";
                beeTerritory[beeRow][beeCol] = ".";
                command = scanner.nextLine();
            }
            if (pollinatedFlowers < 5) {
                System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinatedFlowers);

            } else {
                System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatedFlowers);
            }
            printField(beeTerritory);
        }

    }

    public static void printField(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String item : arr) {
                System.out.print(item + "");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(String[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}