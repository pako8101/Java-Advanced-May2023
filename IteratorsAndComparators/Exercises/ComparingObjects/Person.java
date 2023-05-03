package IteratorsAndComparators.Exercises.ComparingObjects;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age
                && name.equals(person.name)
                && town.equals(person.town);
    }


    //    @Override
//    public int compareTo(Person otherPerson) {
//        if (this.getName().equals(otherPerson.name)) {
//            if (this.getAge() == otherPerson.getAge()) {
//                return this.getTown().compareTo(otherPerson.getTown());
//            } else {
//                return Integer.compare(this.getAge(), otherPerson.getAge());
//            }
//        }
//        return this.getName().compareTo(otherPerson.getName());
//    }
    @Override
    public int compareTo(Person otherPerson) {

    int result = this.name.compareTo(otherPerson.getName());
    if (result==0){
        result = Integer.compare(this.age, otherPerson.getAge());
    }if (result==0){
        result = this.town.compareTo(otherPerson.getTown());
        }
    return result;
    }
}
