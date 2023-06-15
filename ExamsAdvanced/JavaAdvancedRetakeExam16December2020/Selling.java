package ExamsAdvanced.JavaAdvancedRetakeExam16December2020;

import java.util.Scanner;

public class Selling {
    private static int randomRow;
    private static int randomCol;
    private static int money;
    private static boolean isEnoughMoney = false;
    private static boolean isOutOfField = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            field[row] = scanner.nextLine().toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < field[row].length; col++) {
                char currentPosition = field[row][col];
                if (currentPosition == 'S') {
                    randomRow = row;
                    randomCol = col;
//                } else if (currentPosition == 'O') {
//                    pilarRow = row;
//                    pilarCol = col;
                }
            }
        }

        while (true) {
            String command = scanner.nextLine();
            field[randomRow][randomCol] = '-';
            int newRow = randomRow;
            int newCol = randomCol;
            switch (command) {
                case "up":
                    //нагоре
                    newRow--;
                    break;
                case "down":
                    //надолу
                    newRow++;
                    break;
                case "left":
                    //ляво
                    newCol--;
                    //проверка дали сме отвън
                    break;
                case "right":
                    //дясно
                    newCol++;
                    break;
            }
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= rows) {
                isOutOfField = true;
                break;
            }
            char currentPosition = field[newRow][newCol];

            if (Character.isDigit(currentPosition)) {
                money += Character.getNumericValue(currentPosition);
                field[newRow][newCol] = '-';
//            } else if (currentPosition == 'O') {
//                field[randomRow][randomCol] = '-';
//                field[newRow][newCol] = '-';
//                randomRow = newRow;
//                randomCol = newCol;
//            } else {
//                field[randomRow][randomCol] = '-';
//                field[newRow][newCol] = 'S';
//                randomRow = newRow;
//                randomCol = newCol;
//            }
            } else if (currentPosition == 'O') {
                field[newRow][newCol] = '-';
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < rows; col++) {
                        if (field[row][col] == 'O' && (row != newRow && col != newCol)) {
                            field[row][col] = '-';
                            newRow = row;
                            newCol = col;

                        }
                    }
                }

            }

            //field[randomRow][randomCol] = '-';
            field[newRow][newCol] = 'S';
            randomRow = newRow;
            randomCol = newCol;

            if (money >= 50) {
                isEnoughMoney = true;
                break;
            }

        }
        if (isOutOfField) {
            System.out.println("Bad news, you are out of the bakery.");
        } else if (isEnoughMoney) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", money);
        printCharMatrix(field);
    }


    public static void printCharMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
