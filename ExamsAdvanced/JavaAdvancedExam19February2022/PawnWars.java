package ExamsAdvanced.JavaAdvancedExam19February2022;

import java.util.Scanner;

public class PawnWars {
    private static int wRow;
    private static int bRow;
    private static int wCol;
    private static int bCol;
    private static boolean isHit = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] gameBoard = new String[8][8];
        fillMatrix(gameBoard, scanner);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (gameBoard[row][col].equals("b")) {
                    bRow = row;
                    bCol = col;
                } else if (gameBoard[row][col].equals("w")) {
                    wCol = col;
                    wRow = row;
                    break;
                }
            }
        }

        while (wRow != 0 && bRow != 7 && !isHit) {
            if (isWhiteHit(wRow, wCol, bRow, bCol)) {
                System.out.println();
                isHit = true;
            }
            wRow -= 1;
            if (isBlackHit(wRow, wCol, bCol, bRow)) {
                System.out.println();
                isHit = true;
            }
            bRow += 1;
        }
        if (!isHit){
            if (wRow==0){
                System.out.println("is quin");
            } else  {
                System.out.println("is black quin");
            }
        }
    }

    private static boolean isBlackHit(int wRow, int wCol, int bCol, int bRow) {
        return bRow + 1 == wRow && (bCol - 1 == wCol || bCol + 1 == wCol);
    }

    private static boolean isWhiteHit(int wRow, int wCol, int bRow, int bCol) {
        return wRow - 1 == bRow && (wCol - 1 == bCol || wCol + 1 == bCol);
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

}