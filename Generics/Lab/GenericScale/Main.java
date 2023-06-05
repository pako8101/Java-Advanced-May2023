package Generics.Lab.GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<String> stringScale = new Scale<>("a","c");
        System.out.println(stringScale.getHeavier());
        Scale<Integer> integerScale = new Scale<>(5,-1);
        System.out.println(integerScale.getHeavier());
    }
}
