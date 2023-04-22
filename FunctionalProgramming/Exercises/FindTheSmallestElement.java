package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

//        Function<List<Integer>, Integer> function = list -> {
//            int min = Integer.MAX_VALUE;
//            int index = 1;
//            for (int i = 0; i < numbersList.size(); i++) {
//                if (list.get(i) <= min) {
//                    min = list.get(i);
//                    index = i;
//                }
//            }return index;
//        };
//        System.out.println(function.apply(numbersList));

        Function<List<Integer>,Integer> alternative = list->{
            int min = numbersList.stream().mapToInt(e->e).min().getAsInt();
            return list.lastIndexOf(min);
        };
        System.out.println(alternative.apply(numbersList));
    }
}
