package SetsAndMapsAdvanced.Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class HomeWork2Arr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr1 = scanner.nextLine().split(" ");
        String[] arr2 = scanner.nextLine().split(" ");
        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        LinkedHashSet<String> secondSet = new LinkedHashSet<>();
        firstSet.addAll(Arrays.asList(arr1));
        secondSet.addAll(Arrays.asList(arr2));
        firstSet.retainAll(secondSet);
        for (String element : firstSet) {
            System.out.print(element + " ");

        }
    }
}
