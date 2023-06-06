package ExamsAdvanced.JavaAdvancedExam18February2023;

import java.util.*;

public class ApocalypsePreparation {
    private static final int patch = 30;
    private static final int bandage = 40;
    private static final int medKit = 100;
    private static int sum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> healingItems = new ArrayList<>();
        ArrayDeque<Integer> textileQueue = new ArrayDeque<>();
        ArrayDeque<Integer> medicamentStack = new ArrayDeque<>();
        String input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(textileQueue::offer);
        input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(medicamentStack::push);
        while (!textileQueue.isEmpty() && !medicamentStack.isEmpty()) {
            int textileValue = textileQueue.peek();
            int medicamentValue = medicamentStack.peek();
            sum = textileValue + medicamentValue;
            if (sum == patch) {
                healingItems.add("Patch");
                textileQueue.poll();
                medicamentStack.pop();
            } else if (sum == bandage) {
                healingItems.add("Bandage");
                textileQueue.poll();
                medicamentStack.pop();
            } else if (sum == medKit) {
                healingItems.add("MedKit");
                textileQueue.poll();
                medicamentStack.pop();
            } else if (sum > medKit) {
                healingItems.add("MedKit");
                textileQueue.poll();
                medicamentStack.pop();
                medicamentStack.push(sum - medKit + medicamentStack.pop());

            } else {
                textileQueue.poll();
                int returnMed = medicamentStack.pop();
                medicamentStack.push(returnMed + 10);
            }
        }
        if (textileQueue.isEmpty() && medicamentStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textileQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }
        printCreatedItems(healingItems);
       // Collections.sort(healingItems);
//        for (String item : healingItems) {
//            System.out.println(item + " - " + Collections.frequency(healingItems, item));
//        }

        if (!medicamentStack.isEmpty()) {
            System.out.print("Medicaments left: ");
            for (Integer remainingMedicament : medicamentStack) {
                System.out.print(remainingMedicament);
                if (remainingMedicament < medicamentStack.size() - 1) {
                    System.out.print(", ");
                }

            }
            System.out.println();
        }
        if (!textileQueue.isEmpty()) {
            System.out.print("Textiles left: ");
            for (Integer textile : textileQueue) {
                System.out.print(textile);
                if (textile < textileQueue.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

    }

    private static void printCreatedItems(List<String> healingItems) {
        Collections.sort(healingItems, new Comparator<String>() {
            @Override
            public int compare(String item1, String item2) {
                if (item1.equals("MedKit")) {
                    return -1;
                } else if (item2.equals("MedKit")) {
                    return 1;
                } else {
                    return item1.compareTo(item2);
                }
            }

        });

        for (String item : healingItems) {
            System.out.println(item + " - " + Collections.frequency(healingItems, item));
        }
    }

}
