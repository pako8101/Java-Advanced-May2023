package ExamsAdvanced.JavaAdvancedExam20February2021;

import java.util.Scanner;

public class Bomb2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // read field size
        int fieldSize = Integer.parseInt(scanner.nextLine());
        // read commands
        String[] commands = scanner.nextLine().split(",");
        // read field
        char[][] field = new char[fieldSize][fieldSize];
        int bombsCount = 0;
        int sRow = -1;
        int sCol = -1;
        for (int row = 0; row < fieldSize; row++) {
            String[] rowTokens = scanner.nextLine().split("\\s+");
            for (int col = 0; col < fieldSize; col++) {
                char cell = rowTokens[col].charAt(0);
                field[row][col] = cell;
                if (cell == 'B') {
                    bombsCount++;
                } else if (cell == 's') {
                    sRow = row;
                    sCol = col;
                }
            }
        }

        // play the game
        int bombsFound = 0;
        for (String command : commands) {
            switch (command) {
                case "left":
                    if (sCol > 0) {
                        sCol--;
                    }
                    break;
                case "right":
                    if (sCol < fieldSize - 1) {
                        sCol++;
                    }
                    break;
                case "up":
                    if (sRow > 0) {
                        sRow--;
                    }
                    break;
                case "down":
                    if (sRow < fieldSize - 1) {
                        sRow++;
                    }
                    break;
            }
            char cell = field[sRow][sCol];
            if (cell == 'B') {
                bombsFound++;
                bombsCount--;
                System.out.println("You found a bomb!");
                field[sRow][sCol] = '+';
                if (bombsCount == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (cell == 'e') {
                System.out.printf("END! %d bombs left on the field%n", bombsCount);
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bombsCount, sRow, sCol);
    }

}
