package ExamsAdvanced.JavaAdvancedExam19February2022;

import java.util.*;

public class FoodFinder2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Character> vowelsQueue = new ArrayDeque<>();
        Stack<Character> consonantsStack = new Stack<>();

        String vowelsInput = scanner.nextLine();
        String consonantsInput = scanner.nextLine();

        for (char vowel : vowelsInput.toCharArray()) {
            vowelsQueue.offer(vowel);
        }
        for (char consonant : consonantsInput.toCharArray()) {
            consonantsStack.push(consonant);
        }

        List<String> words = Arrays.asList("pear", "flour", "pork", "olive");
        List<String> foundWords = new ArrayList<>();
        while (!consonantsStack.isEmpty()) {
            char consonant = consonantsStack.pop();
            char vowel = vowelsQueue.poll();

            List<String> matchingWords = getMatchingWords(words, vowel, consonant);
            foundWords.addAll(matchingWords);

            vowelsQueue.offer(vowel);
        }

        System.out.printf("Words found: %d%n", foundWords.size());
        for (String word : foundWords) {
            System.out.println(word);
        }
    }

    private static List<String> getMatchingWords(List<String> words, char vowel, char consonant) {
        List<String> matchingWords = new ArrayList<>();

        for (String word : words) {
            if (word.contains(String.valueOf(vowel)) && word.contains(String.valueOf(consonant))) {
                matchingWords.add(word);
            }
        }

        return matchingWords;
    }
}

