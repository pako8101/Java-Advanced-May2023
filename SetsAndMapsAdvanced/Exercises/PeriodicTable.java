package SetsAndMapsAdvanced.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countChemicals = Integer.parseInt(scanner.nextLine());
        TreeSet<String> chemicals = new TreeSet<>();
        while (countChemicals-->0){

            String []compound = scanner.nextLine().split(" ");
            chemicals.addAll(Arrays.asList(compound));
        }
        for (String chemical : chemicals) {
            String result = String.join(" ", chemical);
            System.out.print(result + " ");
        }

    }
}
