package SetsAndMapsAdvanced.Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String,Double> gradesByStudents = new TreeMap<>();

        while (n--> 0){
            String name = scanner.nextLine();

          double grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                  .average()
                  .orElse(0);

            gradesByStudents.put(name,grades);
        }
        DecimalFormat format = new DecimalFormat("###.####");
                gradesByStudents.forEach((name,grades)-> System.out.printf("%s is graduated with %f%n", name,grades));

    }
}
