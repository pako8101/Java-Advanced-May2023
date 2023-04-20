package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>>continents = new LinkedHashMap<>();
        while (n-->0) {

            String[] info = scanner.nextLine().split("\\s+");
            String continent = info[0];
            String country = info[1];
            String city = info[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());

            Map<String, List<String>> countries = continents.get(continent);

            countries.putIfAbsent(country, new ArrayList<>());

            List<String> cities = countries.get(country);

            cities.add(city);

        }
//        continents.entrySet()
//                .forEach(entry->{
//                    System.out.println(entry.getKey() + ":");
//                    entry.getValue().entrySet().stream()
//                            .forEach(inner ->{
//                                String cities = String.join(", ", inner.getValue());
//                                System.out.println(" " + inner.getKey() +  " -> " + cities);
//                            });
//                });
//        for (Map.Entry<String, LinkedHashMap<String, List<String>>> entry : continents.entrySet()) {
//            System.out.println(entry.getKey() + ":");
//            for (Map.Entry<String, List<String>> inner : entry.getValue().entrySet()) {
//                String cities = String.join(", ", inner.getValue());
//                System.out.println(" " + inner.getKey() + " -> " + cities);
         continents.forEach((key, value) -> {
             System.out.println(key + ":");
             value.forEach((key1, value1) -> {
                 String cities = String.join(", ", value1);
                 System.out.println(" " + key1 + " -> " + cities);
             });
         });

            }


}
