package SetsAndMapsAdvanced.Exercises;

import java.util.*;


public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        LinkedHashMap<String, HashSet<String>> mapCardPlayers = new LinkedHashMap<>();
        while (!command.equals("JOKER")) {
            String[] parts = command.split(": ");
            String name = parts[0];
            if (!mapCardPlayers.containsKey(name)) {
                mapCardPlayers.put(name, new HashSet<String>());
            }
            String[] cards = parts[1].split(", ");
            Collections.addAll(mapCardPlayers.get(name), cards);
            command = scanner.nextLine();
//            for (int i = 0; i < cards.length; i++) {
//                String currentCard = cards[i];
//                mapCardPlayers.get(name).add(currentCard);
//            }
        }
        for (var player: mapCardPlayers.entrySet()) {
            String name = player.getKey();
            int points = getPoints(player.getValue());
            System.out.printf("%s: %d%n", name,points);
        }
//        Iterator var8 = mapCardPlayers.entrySet().iterator();
//        while (var8.hasNext()) {
//            Map.Entry<String, HashSet<String>> player = (Map.Entry)var8.next();
//            String name = (String)player.getKey();
//            int points = getPoints((HashSet)player.getValue());
//            System.out.printf("%s : %d%n", name,points);
//        }
    }

    private static int getPoints(HashSet<String> cards) {
        int points = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            String color = card.substring(card.length() - 1);
            int cardPoints = getPower(power) * getColor(color);
            points+=cardPoints;
        }
        return points;
    }

    private static int getColor(String color) {
        switch (color){
            case "S":
                return 4;
            case "H":
                return 3;
            case "D":
                return 2;
            case "C":
                return 1;
            default:
                return 0;
        }

    }

    private static int getPower(String power) {
        switch (power) {
            case "2":
                return 2;

            case "3":
                return 3;

            case "4":
                return 4;

            case "5":
                return 5;

            case "6":
                return 6;

            case "7":
                return 7;

            case "8":
                return 8;

            case "9":
                return 9;

            case "10":
                return 10;

            case "J":
                return 11;

            case "Q":
                return 12;

            case "K":
                return 13;

            case "A":
                return 14;
            default:
                return 0;
        }

    }
}
