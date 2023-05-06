package Generics.Exercises.GenericCountMethodStrings;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
           String element = scanner.nextLine();
            box.add(element);
        }
//        int [] indexes= Arrays. stream(scanner.nextLine().split(" "))
//                        .mapToInt(Integer::parseInt)
//                        .toArray();
//        int firstIndex = indexes[0];
//        int secondIndex = indexes[1];
//        box.swap(firstIndex,secondIndex);
        String elementToCompare = scanner.nextLine();
        System.out.println( box.countGreaterItems(elementToCompare));

    }
}
