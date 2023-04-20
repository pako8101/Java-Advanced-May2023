package SetsAndMapsAdvanced.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> vipGuest = new TreeSet<>();
        Set<String> regularGuest = new TreeSet<>();
        while (!input.equals("PARTY")) {
            boolean isVip = Character.isDigit(input.charAt(0));
            if (isVip) {
                vipGuest.add(input);
            } else {
                regularGuest.add(input);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")) {

            boolean isVip = Character.isDigit(input.charAt(0));
            if (isVip) {
                vipGuest.remove(input);
            } else {
                regularGuest.remove(input);
            }
                input = scanner.nextLine();
            }
            System.out.println(vipGuest.size() + regularGuest.size());
            for (String r:vipGuest) {
                System.out.println(r);
            }
            for (String r: regularGuest
                 ) {
                System.out.println(r);
            }
    }
}
