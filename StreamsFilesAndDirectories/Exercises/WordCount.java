package StreamsFilesAndDirectories.Exercises;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Scanner wordScanner = new Scanner(new FileReader("src/StreamsFilesAndDirectories/Exercises/Exercises Resources/words.txt"));
        String[] wordsToSearch = wordScanner.nextLine().split("\\s+");

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String word : wordsToSearch) {
            map.put(word.toLowerCase(), 0);
        }
        Scanner fileScanner = new Scanner(new FileReader("src/StreamsFilesAndDirectories/Exercises/Exercises Resources/text.txt"));
        String singleWord = fileScanner.next().toLowerCase();
        while (fileScanner.hasNext()) {
            if (map.containsKey(singleWord)) {
                int occurrences = map.get(singleWord);
                occurrences++;
                map.put(singleWord, occurrences);

            }
            singleWord = fileScanner.next();

        }
        PrintWriter pw = new PrintWriter(new FileWriter("src/StreamsFilesAndDirectories/Exercises/Exercises Resources/result.txt"));
        map.entrySet().stream().sorted((f,s)->s.getValue() - f.getValue())
                .forEach(entry -> pw.printf("%s - %d%n",entry.getKey() ,entry.getValue()));
        fileScanner.close();
        wordScanner.close();
        pw.close();
    }
}
