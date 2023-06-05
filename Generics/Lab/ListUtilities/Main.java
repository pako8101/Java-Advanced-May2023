package Generics.Lab.ListUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer>numbers = Arrays.asList(3,5,9);
        System.out.println(ListUtils.getMax(numbers));
        List<String>stringList = new ArrayList<>();
        Collections.addAll(stringList,"b","n","f");
        System.out.println(ListUtils.getMin(stringList));
    }
}
