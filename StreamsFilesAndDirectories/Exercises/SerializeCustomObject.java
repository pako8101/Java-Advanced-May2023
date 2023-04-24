package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course = new Course();
        course.name = "Java Advanced May 2023";
        course.numberOfStudents = 250;
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/StreamsFilesAndDirectories/Exercises/Exercises Resources/courses.ser"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/StreamsFilesAndDirectories/Exercises/Exercises Resources/courses.ser"));

        output.writeObject(course);

        Course courseFromFile = (Course) input.readObject();
        System.out.println(courseFromFile.numberOfStudents);
        System.out.println(courseFromFile.name);


    }
}
