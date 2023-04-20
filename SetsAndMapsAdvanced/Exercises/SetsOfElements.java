package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizes = scanner.nextLine().split(" ");
        int lengthFirst = Integer.parseInt(sizes[0]);
        int lengthSecond = Integer.parseInt(sizes[1]);

        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < lengthFirst; i++) {
            String element = scanner.nextLine();
            firstSet.add(element);
        }
        LinkedHashSet<String>secondSet = new LinkedHashSet<>();
        for (int i = 0; i < lengthSecond; i++) {
            String element = scanner.nextLine();
            secondSet.add(element);
//        }
//        for (String element : firstSet) {
//            if (secondSet.contains(element)){
//                System.out.print(element + " ");
//            }
        }
            firstSet.retainAll(secondSet);//оставя само тези който се съдържат и в двата сета
            for (String element : firstSet) {
                System.out.print(element + " ");
        }
    }
}
