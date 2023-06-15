package ExamsAdvanced.JavaAdvancedRetakeExam14December2022;

import java.util.*;

public class ClimbThePeaks {

    private static boolean isPeekClimbed = false;
    private static int sum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dailyPortion = scanner.nextLine().split(", ");
        String[] dailyStamina = scanner.nextLine().split(", ");
        Stack<Integer> stackFood = new Stack<>();
        Arrays.stream(dailyPortion).mapToInt(Integer::parseInt).forEach(stackFood::push);

        Queue<Integer> queueStamina = new ArrayDeque<>();
        Arrays.stream(dailyStamina).mapToInt(Integer::parseInt).forEach(queueStamina::offer);
        List<String> peaks = new ArrayList<>(Arrays.asList("Vihren",
                "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));
        Map<String, Integer> peeksMap = getPeeksMap();

        Set<String> conqueredPeeks = new LinkedHashSet<>();
        while (!peeksMap.isEmpty() && !queueStamina.isEmpty() && !stackFood.isEmpty()) {
            int stamina = queueStamina.peek();
            int food = stackFood.peek();
            sum = food + stamina;
            //   for (Map.Entry<String, Integer> entry : peeksMap.entrySet()) {
            String currentPeek = peaks.get(0);
            if (sum >= peeksMap.get(currentPeek)) {
                conqueredPeeks.add(currentPeek);
                stackFood.pop();
                queueStamina.poll();
                peeksMap.remove(currentPeek);
                peaks.remove(currentPeek);
            } else {
                stackFood.pop();
                queueStamina.poll();
            }
        }
//                if (conqueredPeeks.size() == peeksMap.size()) {
//                    isPeekClimbed = true;
//                    break;
//
//            }


        if (peeksMap.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");

        }
        if (!conqueredPeeks.isEmpty()) {
            System.out.println("Conquered peaks:");
            conqueredPeeks.forEach(System.out::println);

        }
    }

    private static Map<String, Integer> getPeeksMap() {
        Map<String, Integer> peeksMap = new LinkedHashMap<>();
        peeksMap.put("Vihren", 80);
        peeksMap.put("Kutelo", 90);
        peeksMap.put("Banski Suhodol", 100);
        peeksMap.put("Polezhan", 60);
        peeksMap.put("Kamenitza", 70);
        return peeksMap;
    }
}
