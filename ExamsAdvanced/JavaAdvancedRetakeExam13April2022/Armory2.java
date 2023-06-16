package ExamsAdvanced.JavaAdvancedRetakeExam13April2022;

import java.util.Scanner;

public class Armory2 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int n = Integer.parseInt(scanner.nextLine());

            char[][] armory = new char[n][n];
            int[] officerPosition = new int[2];
            int swordProfit = 0;

            // Read the armory layout
            for (int i = 0; i < n; i++) {
                String row = scanner.nextLine();
                for (int j = 0; j < n; j++) {
                    armory[i][j] = row.charAt(j);
                    if (armory[i][j] == 'A') {
                        officerPosition[0] = i;
                        officerPosition[1] = j;
                    }
                }
            }

            // Process the moves
            while (true) {
                String move = scanner.nextLine();
                int newRow = officerPosition[0];
                int newCol = officerPosition[1];

                if (move.equals("up")) {
                    newRow--;
                } else if (move.equals("down")) {
                    newRow++;
                } else if (move.equals("left")) {
                    newCol--;
                } else if (move.equals("right")) {
                    newCol++;
                }

                // Check if the new position is valid
                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                    System.out.println("I do not need more swords!");
                    System.out.println("The king paid " + swordProfit + " gold coins.");
                    printArmory(armory);
                    return;
                }

                // Process the new position
                char newPosition = armory[newRow][newCol];
                if (newPosition == '-') {
                    // Empty position, move the officer
                    armory[officerPosition[0]][officerPosition[1]] = '-';
                    armory[newRow][newCol] = 'A';
                    officerPosition[0] = newRow;
                    officerPosition[1] = newCol;
                } else if (Character.isDigit(newPosition)) {
                    // Sword position, buy the sword
                    int swordPrice = Character.getNumericValue(newPosition);
                    swordProfit += swordPrice;
                    armory[officerPosition[0]][officerPosition[1]] = '-';
                    armory[newRow][newCol] = 'A';
                    officerPosition[0] = newRow;
                    officerPosition[1] = newCol;
                    if (swordProfit >= 65) {
                        System.out.println("Very nice swords, I will come back for more!");
                        System.out.println("The king paid " + swordProfit + " gold coins.");
                        printArmory(armory);
                        return;
                    }
                } else if (newPosition == 'M') {
                    // Mirror position, teleport the officer
                    int mirrorRow = -1;
                    int mirrorCol = -1;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (armory[i][j] == 'M' && (i != newRow || j != newCol)) {
                                mirrorRow = i;
                                mirrorCol = j;
                                break;
                            }
                        }
                    }
                    armory[officerPosition[0]][officerPosition[1]] = '-';
                    armory[mirrorRow][mirrorCol] = 'A';
                    officerPosition[0] = mirrorRow;
                    officerPosition[1] = mirrorCol;
                }
            }
        }

        private static void printArmory(char[][] armory) {
            for (char[] row : armory) {
                for (char cell : row) {
                    System.out.print(cell);
                }
                System.out.println();
            }
        }
    }

