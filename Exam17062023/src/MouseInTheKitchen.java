import java.util.Scanner;

public class MouseInTheKitchen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(",");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        char[][] cupboard = new char[rows][columns];
        int mouseRow = -1;
        int mouseCol = -1;
        int cheeseCount = 0;

        for (int row = 0; row < rows; row++) {
            String rowFromConsole = scanner.nextLine();
            for (int col = 0; col < columns; col++) {
                cupboard[row][col] = rowFromConsole.charAt(col);
                if (cupboard[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                } else if (cupboard[row][col] == 'C') {
                    cheeseCount++;
                }
            }
        }

        String direction = scanner.nextLine();
        boolean isTrapped = false;
        boolean isDanger = false;

        while (!direction.equals("danger")) {
            int newRow = mouseRow;
            int newCol = mouseCol;
            cupboard[newRow][newCol] = '*';
            if (direction.equals("up")) {
                newRow--;
            } else if (direction.equals("down")) {
                newRow++;
            } else if (direction.equals("left")) {
                newCol--;
            } else if (direction.equals("right")) {
                newCol++;
            }

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= columns) {
                cupboard[mouseRow][mouseCol] = 'M';
                System.out.println("No more cheese for tonight!");
                isDanger = true;
                break;
            }

            if (cupboard[newRow][newCol] == '@') {
                direction = scanner.nextLine();
                continue;
            }

            if (cupboard[newRow][newCol] == 'T') {
                cupboard[newRow][newCol] = 'M';
                isTrapped = true;
                break;
            }

            if (cupboard[newRow][newCol] == 'C') {
                cupboard[newRow][newCol] = 'M';
               // cupboard[newRow][newCol] = '*';
                cheeseCount--;

                if (cheeseCount == 0) {
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    break;
                }
            }
            cupboard[newRow][newCol] = 'M';
            cupboard[mouseRow][mouseCol] = '*';
            mouseRow = newRow;
            mouseCol = newCol;

            direction = scanner.nextLine();
        }

        if (isTrapped) {
            System.out.println("Mouse is trapped!");
        } else if (cheeseCount > 0 && !isDanger) {
            System.out.println("Mouse will come back later!");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(cupboard[i][j]);
            }
            System.out.println();
        }
    }
}

