package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        while (!input.equals("end")) {
            String[] inputPArts = input.split("\\s+");
            String username = inputPArts[2].substring(5);
            String IP = inputPArts[0].substring(3);

            if (!users.containsKey(username)) {
                users.put(username, new LinkedHashMap<>());
            }
            if (!users.get(username).containsKey(IP)) {
                users.get(username).put(IP, 1);

            } else {
                int currentCount = users.get(username).get(IP) + 1;
                users.get(username).put(IP, currentCount);
            }
            input = scanner.nextLine();
        }
        for (var item : users.entrySet()) {
            System.out.printf("%s: %n", item.getKey());
            LinkedHashMap<String, Integer> attacks = item.getValue();
            StringBuilder builder = new StringBuilder();
            for (var iPAttack : attacks.entrySet()) {
                builder.append(String.format("%s => %d, ", iPAttack.getKey(), iPAttack.getValue()));
            }
            String finalOut = builder.substring(0, builder.length() - 2);
            System.out.println(finalOut + ".");
        }
    }
}
