package ExamsAdvanced.ExamPreparation10February2022;

import java.util.Scanner;

public class Cookingjourney {
    private static int firstPillarRow;
    private static int firstPillarCol;
    private static int secondPillarRow;
    private static int secondPillarCol;
    private static int money;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[][] pastryShop = new String[size][size];
        int currentRow = 0;
        int currentCol = 0;
        fillMatrix(pastryShop, scanner);
        printMatrix(pastryShop);
        boolean weFoundFirstPillar = false;
        for (int row = 0; row < pastryShop.length; row++) {
            for (int col = 0; col < pastryShop.length; col++) {
                if (pastryShop[row][col].equals("S")) {
                    currentRow = row;
                    currentCol = col;
                }
                if (pastryShop[row][col].equals("P") && !weFoundFirstPillar) {
                    firstPillarRow = row;
                    firstPillarCol = col;
                    weFoundFirstPillar = true;
                }
                if (pastryShop[row][col].equals("P") && weFoundFirstPillar) {
                    secondPillarRow = row;
                    secondPillarCol = col;

                }

                while (money < 50) {
                    String command = scanner.nextLine();
                    int oldRow = currentRow;
                    int oldCol = currentCol;
                    switch (command) {
                        case "left":
                            currentCol--;
                            break;
                        case "right":
                            currentCol++;
                            break;
                        case "down":
                            currentRow++;
                            break;
                        case "up":
                            currentRow--;
                            break;
                    }
                    if (currentRow < 0 || currentRow >= size || currentCol < 0 ||
                            currentCol >= size) {
                        pastryShop[oldRow][oldCol] = "-";
                        break;

                    }
                    if (currentRow == firstPillarRow && currentCol == firstPillarCol) {
                        currentCol = secondPillarCol;
                        currentRow = secondPillarRow;
                        pastryShop[oldRow][oldCol] = "-";
                        pastryShop[firstPillarRow][firstPillarCol] = "-";
                        pastryShop[currentRow][currentCol] = "S";
                    }
                   else if (currentRow == secondPillarRow && currentCol == secondPillarCol) {
                        currentCol = firstPillarCol;
                        currentRow = firstPillarRow;
                        pastryShop[oldRow][oldCol] = "-";
                        pastryShop[secondPillarRow][secondPillarCol] = "-";
                        pastryShop[currentRow][currentCol] = "S";

                    }else if (pastryShop[currentRow][currentCol] .equals("-")){
                        pastryShop[oldRow][oldCol] = "-";
                        pastryShop[currentRow][currentCol] = "S";
                    }else {
                       money += Integer.parseInt(pastryShop[currentRow][currentCol]);
                        pastryShop[oldRow][oldCol] = "-";
                        pastryShop[currentRow][currentCol] = "S";

                    }
//                    System.out.println(firstPillarCol);
//                    System.out.println(firstPillarRow);
//                    System.out.println(pastryShop[firstPillarRow][firstPillarCol]);
//                    System.out.println(secondPillarCol);
//                    System.out.println(secondPillarRow);
//                    System.out.println(pastryShop[secondPillarRow][secondPillarCol]);
                }
                if (money >= 50) {
                    System.out.println("Good news! You succeeded in collecting enough money!");
                } else {
                    System.out.println("Bad news! You are out of the pastry shop.");
                }
                System.out.printf("Money: %d", money);
                printMatrix(pastryShop);
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
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}