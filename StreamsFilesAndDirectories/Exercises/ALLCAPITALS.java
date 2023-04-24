package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("src/StreamsFilesAndDirectories/Exercises/Exercises Resources/output.txt"));
        BufferedReader br = new BufferedReader(new FileReader("src/StreamsFilesAndDirectories/Exercises/Exercises Resources/input.txt"));
        br.lines().forEach(line-> pw.println(line.toUpperCase()));
        br.close();
        pw.close();
    }
}
