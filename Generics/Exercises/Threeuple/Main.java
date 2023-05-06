package Generics.Exercises.Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String name = input[0] + " " + input[1];
        String city = input[2];
        String nameSecond = input[3];


        Threeuple<String, String, String> firstTuple = new Threeuple<>(name, city, nameSecond);
        System.out.println(firstTuple);
        input = scanner.nextLine().split(" ");
        String firstName = input[0];
        Integer litersBeer = Integer.parseInt(input[1]);
        String secName = input[2];
        boolean isDrunk = secName.equals("drunk");
        if (isDrunk) {
            Threeuple<String, Integer, String> secondTuple = new Threeuple(firstName, litersBeer, true);
            System.out.println(secondTuple);
        } else {
            Threeuple<String, Integer, String> secondTuple = new Threeuple(firstName, litersBeer, false);
            System.out.println(secondTuple);
        }

        input = scanner.nextLine().split(" ");
        String name1 = input[0];
        double num = Double.parseDouble(input[1]);
        String name2 = input[2];

        Threeuple<String, Double, String> thirdTuple = new Threeuple(name1, num, name2);


        System.out.println(thirdTuple);
    }
}
