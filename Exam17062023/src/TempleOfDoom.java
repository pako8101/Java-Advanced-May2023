import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TempleOfDoom {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split("\\s+");
        String[] input2 = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        Arrays.stream(input1).mapToInt(Integer::parseInt).forEach(toolsQueue::offer);

        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        Arrays.stream(input2).mapToInt(Integer::parseInt).forEach(substancesStack::push);


        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while ((!toolsQueue.isEmpty() && !substancesStack.isEmpty()) && !challenges.isEmpty()) {
            int tool = toolsQueue.poll();
            int substance = substancesStack.pop();
           int sum = tool * substance;

            if (challenges.contains(sum)) {
                challenges.remove(Integer.valueOf(sum));
            } else {
                toolsQueue.offer(tool + 1);
                if (substance > 1) {
                    substancesStack.push(substance - 1);
                }
            }
        }

        if (!challenges.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        if (!toolsQueue.isEmpty()) {
            System.out.println("Tools: " + toolsQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        if (!substancesStack.isEmpty()) {
            System.out.println("Substances: " + substancesStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        if (!challenges.isEmpty()) {
            System.out.println("Challenges: " + challenges.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}
