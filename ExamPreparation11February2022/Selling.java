package ExamPreparation11February2022;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine()
                    .toCharArray();

        }


    }
}
