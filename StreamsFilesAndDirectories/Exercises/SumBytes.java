package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader("src/StreamsFilesAndDirectories/Exercises/Exercises Resources/input.txt"))) {
            String line = reader.readLine();
            long sum = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    sum += c;

                }
                line = reader.readLine();
            }
            System.out.println(sum);
            reader.close();
        }

        }
}

