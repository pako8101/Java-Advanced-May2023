package Generics.Exercises.GenericCountMethodDoubles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> box = new Box<>();
        for (int i = 0; i < n; i++) {
           double element = Double.parseDouble(scanner.nextLine());
            box.add(element);
        }
//        int [] indexes= Arrays. stream(scanner.nextLine().split(" "))
//                        .mapToInt(Integer::parseInt)
//                        .toArray();
//        int firstIndex = indexes[0];
//        int secondIndex = indexes[1];
//        box.swap(firstIndex,secondIndex);
        double elementToCompare = Double.parseDouble(scanner.nextLine());
        System.out.println( box.countGreaterItems(elementToCompare));

    }
}
