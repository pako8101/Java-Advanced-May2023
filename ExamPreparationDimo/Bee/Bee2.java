package ExamPreparationDimo.Bee;

import java.util.Scanner;

public class Bee2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

    char[][] territory = new char[n][n];
    int beeRow = -1, beeCol = -1;
    int flowers = 0, bonus = 0;

    for (int i = 0; i < n; i++) {
        String row = scanner.nextLine();
        for (int j = 0; j < n; j++) {
            territory[i][j] = row.charAt(j);
            if (territory[i][j] == 'B') {
                beeRow = i;
                beeCol = j;
            } else if (territory[i][j] == 'f') {
                flowers++;
            } else if (territory[i][j] == 'O') {
                bonus++;
            }
        }
    }

    String command = scanner.nextLine();

    while (!command.equals("End")) {
        int nextRow = beeRow, nextCol = beeCol;

        switch (command) {
            case "up":
                nextRow--;
                break;
            case "down":
                nextRow++;
                break;
            case "left":
                nextCol--;
                break;
            case "right":
                nextCol++;
                break;
        }


        char nextCell = territory[nextRow][nextCol];

        if (nextCell == 'f') {
            flowers++;
        } else if (nextCell == 'O') {
            bonus++;
            if (bonus == 1) {
                if (command.equals("up")) {
                    nextRow--;
                } else if (command.equals("down")) {
                    nextRow++;
                } else if (command.equals("left")) {
                    nextCol--;
                } else if (command.equals("right")) {
                    nextCol++;
                }
                else {
                    territory[nextRow][nextCol]='.' ;
                    System.out.println("The bee got lost!");
                    break;
                }
            }
        }

        territory[beeRow][beeCol] = '.';
        territory[nextRow][nextCol] = 'B';
        beeRow = nextRow;
        beeCol = nextCol;

        if (flowers >= 5) {
            System.out.println("Great job, the bee manage to pollinate " + flowers + " flowers!");
            break;
        }

        command = scanner.nextLine();
    }

    if (flowers < 5) {
        int needed = 5 - flowers;
        System.out.println("The bee couldn't pollinate the flowers, she needed " + needed + " flowers more");
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(territory[i][j]);
        }
        System.out.println();
    }
}
}
