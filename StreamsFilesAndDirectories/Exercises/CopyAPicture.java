package StreamsFilesAndDirectories.Exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/StreamsFilesAndDirectories/Exercises/Exercises Resources/IMG_5475.jpg");
        FileOutputStream fos = new FileOutputStream("src/StreamsFilesAndDirectories/Exercises/Exercises Resources/IMG_5475Copy.jpg");

        byte[] buffer = new byte[1024];
        while (fis.read(buffer) >= 0){
            fos.write(buffer);
        }
        fis.close();
        fos.close();
    }
}
