import java.util.*;
import java.util.stream.Collectors;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] toolsInput = scanner.nextLine().split(" ");
        Queue<Integer> tools = new LinkedList<>();
        for (String tool : toolsInput) {
            tools.offer(Integer.parseInt(tool));
        }

        // Read the substances
        String[] substancesInput = scanner.nextLine().split(" ");
        ArrayDeque<Integer> substances = new ArrayDeque<>();
        for (String substance : substancesInput) {
            substances.push(Integer.parseInt(substance));
        }

        // Read the challenges
        String[] challengesInput = scanner.nextLine().split(" ");
        List<Integer> challenges = new ArrayList<>();
        for (String challenge : challengesInput) {
            challenges.add(Integer.parseInt(challenge));
        }

        // Process the challenges
        while ((!challenges.isEmpty() && (!tools.isEmpty()) || !substances.isEmpty())) {
            int tool = tools.peek();
            int substance = substances.peek();
            int result = tool + substance;

            if (challenges.contains(result)) {
                challenges.remove(Integer.valueOf(result));
                tools.poll();
                substances.pop();
            } else {

                substances.push( substances.pop()- 1);
                tools.offer(tools.poll() + 1);

                if (substance == 0) {
                    substances.pop();
                }
            }
        }

            // Print the output
            if (substances.isEmpty()) {
                System.out.println("Harry is lost in the temple. Oblivion awaits him.");
            } else {
                System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
            }

            if (!tools.isEmpty()) {
                System.out.print("Tools: ");
                String result1 = tools.stream().map(String::valueOf)
                        .collect(Collectors.joining(", "));
                System.out.println(result1);
            }  if (!substances.isEmpty()) {
                System.out.print("Substances: ");
                String result2 = substances.stream().map(String::valueOf)
                        .collect(Collectors.joining(", "));
                System.out.println(result2);
            }  if (!challenges.isEmpty()) {
                System.out.print("Challenges: ");
                String result3 = challenges.stream().map(String::valueOf)
                        .collect(Collectors.joining(", "));
                System.out.println(result3);
            }
        }
    }
