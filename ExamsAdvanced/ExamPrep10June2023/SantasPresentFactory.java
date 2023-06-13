package ExamsAdvanced.ExamPrep10June2023;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    private static final int Doll = 150;
    private static final int Wooden_train = 250;
    private static final int Teddy_bear = 300;
    private static final int Bicycle = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String materialInput = scanner.nextLine();
        String magicsInput = scanner.nextLine();
        Stack<Integer> materialsStack = new Stack<>();
        Arrays.stream(materialInput.split("\\s+"))
                .map(Integer::parseInt).forEach(materialsStack::push);

       Queue<Integer> magicsQueue = Arrays.stream(magicsInput.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> presentMap = new TreeMap<>();
        presentMap.put("Doll", 0);
        presentMap.put("Wooden train", 0);
        presentMap.put("Teddy bear", 0);
        presentMap.put("Bicycle", 0);
        while (!materialsStack.isEmpty() && !magicsQueue.isEmpty()) {
            int material = materialsStack.peek();
            int magic = magicsQueue.peek();
            int totalMagic = magic * material;

            if (totalMagic == Doll) {
                materialsStack.pop();
                magicsQueue.poll();
                presentMap.put("Doll", presentMap.get("Doll") + 1);

            } else if (totalMagic == Wooden_train) {
                materialsStack.pop();
                magicsQueue.poll();
                presentMap.put("Wooden train", presentMap.get("Wooden train") + 1);

            } else if (totalMagic == Teddy_bear) {
                materialsStack.pop();
                magicsQueue.poll();
                presentMap.put("Teddy bear", presentMap.get("Teddy bear") + 1);

            } else if (totalMagic == Bicycle) {
                materialsStack.pop();
                magicsQueue.poll();
                presentMap.put("Bicycle", presentMap.get("Bicycle") + 1);

            } else if (totalMagic < 0) {
                int sum = material + magic;
                materialsStack.pop();
                magicsQueue.poll();
                materialsStack.push(sum);

            } else if (totalMagic > 0) {
                magicsQueue.poll();
                materialsStack.push(materialsStack.pop() + 15);
            } else {
                if (magic == 0) {
                    magicsQueue.poll();
                }
                if (material == 0)
                    materialsStack.pop();

            }
        }

        boolean isDollAndTrain = presentMap.get("Doll") > 0 && presentMap.get("Wooden train") > 0;
        boolean isBearAndBicycle = presentMap.get("Teddy bear") > 0 && presentMap.get("Bicycle") > 0;
        if (isBearAndBicycle || isDollAndTrain) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
           Collections.reverse(materialsStack);
            System.out.println(materialsStack.toString().replace("[", "").replace("]",""));
        }
        if (!magicsQueue.isEmpty()) {
            System.out.print("Magics left: ");
            System.out.println(magicsQueue.toString().replace("[", "").replace("]",""));
        }

        for (Map.Entry<String, Integer> entry : presentMap.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());

            }
        }
    }

}
