package ExamsAdvanced.ExamPreparation13February2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);


        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);
        int currentRow = -1;
        int currentCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals("Y")) {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }
        List<String> directions = new ArrayList<>();

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Finish")) {
                break;
            }
            //matrix[currentRow][currentCol] = "-";
            directions.add(command);
        }
        boolean foundTreasure = false;
        List<String> path = new ArrayList<>();
        for (String direction : directions) {
            int newRow = 0, newCol = 0;
            if (direction.equals("up")) {
                newRow--;
            } else if (direction.equals("down")) {
                newRow++;
            } else if (direction.equals("left")) {
                newCol--;
            } else if (direction.equals("right")) {
                newCol++;
            }
            int newY = currentRow + newRow, newX = currentCol + newCol;
            if (newY < 0 || newY >= rows || newX < 0 || newX >= cols) {
                // out of field
                continue;
            }
            String currentPosition = matrix[newY][newX];
            if (currentPosition.equals("T")) {
                continue;
            }
            path.add(direction);

            if (currentPosition.equals("X")) {
                foundTreasure = true;
                break;
            }
            currentRow = newY;
            currentCol = newX;
        }
        if (foundTreasure) {
            System.out.println("I've found the treasure!");

            System.out.println("The right path is " + String.join(", ", path));


        } else {
            System.out.println("The map is fake!");

        }

    }


    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}