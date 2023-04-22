package FunctionalProgramming.Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class Practice {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Pako", 2);
        map.put("Boiko", 3);
        map.put("Gosho", 4);
        map.forEach((key, value) -> System.out.println(key + value));
        map.keySet().stream().forEach(System.out::println);
        map.values().stream().forEach(System.out::println);
    }


    Function<String, Integer> function = Integer::parseInt;
    UnaryOperator<String> unaryOperator = s -> "Hello " + s;
    Predicate<String> predicate = s -> s.length() > 5;
    Consumer<String> consumer = System.out::println;
    Supplier<String> supplier = () -> "Boiko";

    BiFunction<String, Integer, Integer> biFunction = (text, number) -> text.length() + number;
    BiPredicate<String, String> biPredicate = (text1, text2) -> text1.length() > text2.length();
    BiConsumer<String, String> biConsumer = (text1, text2) -> System.out.println(text1 + text2);
    BinaryOperator<Integer> binaryOperator = Integer::sum;
}

