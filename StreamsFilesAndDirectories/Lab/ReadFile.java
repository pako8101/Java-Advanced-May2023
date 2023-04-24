package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        String path = "src//StreamsFilesAndDirectories//Lab//Resoureces//input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)) {
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
           // System.out.println("The file" + path + " is missing");
             e.printStackTrace();
        }                     finally {
            System.out.println("I'm bossss");
        }


    }
}
