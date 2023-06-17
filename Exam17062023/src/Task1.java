import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task1 {
    private static int sum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");
        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        Arrays.stream(input1).mapToInt(Integer::parseInt).forEach(toolsQueue::offer);

        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        Arrays.stream(input2).mapToInt(Integer::parseInt).forEach(substancesStack::push);

        List<Integer> challenges = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        while ((!toolsQueue.isEmpty() || !substancesStack.isEmpty())&& !challenges.isEmpty()) {
            int tool = toolsQueue.peek();
            int substance = substancesStack.peek();
            sum = tool + substance;
            if (challenges.contains(sum)) {
                toolsQueue.poll();
                substancesStack.pop();
                challenges.remove(Integer.valueOf(sum));
            } else {
                toolsQueue.offer( toolsQueue.poll()+ 1);
                substancesStack.push(substancesStack.pop() - 1);
                if (substance == 0) {
                    substancesStack.pop();
                }
            }
        }
            if (!challenges.isEmpty()) {
                System.out.println("Harry is lost in the temple. Oblivion awaits him.");

            } else {
                System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
            }
            if (!toolsQueue.isEmpty()) {
                System.out.println("Tools: ");
                String result1 = toolsQueue.stream().map(String::valueOf)
                        .collect(Collectors.joining(", "));
                System.out.println(result1);
            }  if (!substancesStack.isEmpty()) {
                System.out.println("Substances: ");
                String result2 = substancesStack.stream().map(String::valueOf)
                        .collect(Collectors.joining(", "));
                System.out.println(result2);
            }  if (!challenges.isEmpty()) {
                System.out.println("Challenges: ");
                String result3 = challenges.stream().map(String::valueOf)
                        .collect(Collectors.joining(", "));
                System.out.println(result3);
            }

        }

    }



