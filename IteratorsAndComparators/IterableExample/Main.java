package IteratorsAndComparators.IterableExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Shelf shelf = new Shelf("Apple","Banana", "Pear", "Watermelon");
        for (String s:shelf) {
            System.out.println(s);
        }
//        Iterator<String> seller = shelf.iterator();
//        while (seller.hasNext()){
//            System.out.println(seller.next());
//        }


    }
}
