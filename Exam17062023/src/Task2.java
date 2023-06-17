import java.util.Scanner;

public class Task2 {
    private static int santaRow ; //на кой ред се намира
    private  static int santaCol ; //на коя колона се намира
    private  static int count ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int presentsCount = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);


        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("S")) {
                    santaRow = row;
                    santaCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {
            matrix[santaRow][santaCol] = "-";
            switch (command) {
                case "up":
                    //нагоре
                    santaRow--;
                    break;
                case "down":
                    //надолу
                    santaRow++;
                    break;
                case "left":
                    //ляво
                    santaCol--;
                    //проверка дали сме отвън
                    break;
                case "right":
                    //дясно
                    santaCol++;
                    break;
            }
        }
    }
         private static void fillMatrix(String[][] matrix, Scanner scanner) {
             for (int row = 0; row < matrix.length; row++) {
                 matrix[row] = scanner.nextLine().split("\\s+");
             }
         }
          static void printMatrix(String[][] matrix) {
              for (int row = 0; row < matrix.length; row++) {
                  for (int col = 0; col < matrix[0].length; col++) {
                      System.out.print(matrix[row][col] + " ");
                  }
                  System.out.println();
              }
          }
}
