package JavaAdvanced2023MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");
        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        int rowThief = -1;//текущ ред на крадеца
        int colThief = -1;//текуща колона накрадеца
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("D")) {
                    rowThief = row;
                    colThief = col;
                    break;
                }
            }
        }
        int totalStolenMoney = 0;
        //изпълняваме посоките
        for (String direction : directions) {
            switch (direction) {
                case "left":
                    if (colThief - 1 < 0) {
                        //излизам от матрицата
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        //може да се предвижа
                        matrix[rowThief][colThief] = "+";
                        //премествам се
                        colThief--;
                    }

                    break;
                case "right":
                    if (colThief + 1 >= size) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[rowThief][colThief] = "+";
                        colThief++;
                    }
                    break;
                case "up":
                    if (rowThief - 1 < 0) {

                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[rowThief][colThief] = "+";
                        rowThief--;
                    }
                    break;
                case "down":
                    if (rowThief + 1 >= size) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[rowThief][colThief] = "+";
                        rowThief++;
                    }
                    break;
            }
            int moneyStolen = 0;
            String currentPosition = matrix[rowThief][colThief];
            if (currentPosition.equals("$")) {
                moneyStolen = rowThief * colThief;
                System.out.printf("You successfully stole %d$.%n", moneyStolen);
                totalStolenMoney += moneyStolen;
                matrix[rowThief][colThief] = "D";
            } else if (currentPosition.equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
                matrix[rowThief][colThief] = "#";
                printMatrix(matrix);
                return;
            } else if (currentPosition.equals("+")) {
                matrix[rowThief][colThief] = "D";

            }

        } System.out.printf("Your last theft has finished successfully with" +
                " %d$ in your pocket.%n", totalStolenMoney);
        printMatrix(matrix);

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
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
