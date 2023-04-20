package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> valuesWithOccurrences = new LinkedHashMap<>();
        for (Double value:values) {
            if (!valuesWithOccurrences.containsKey(value)){
                valuesWithOccurrences.put(value,1);
            }else {
            valuesWithOccurrences.put(value,valuesWithOccurrences.get(value+1));
            }
        }
        for (Double v: valuesWithOccurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", v, valuesWithOccurrences.get(v));
        }
    }
}
