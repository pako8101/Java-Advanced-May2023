package DefiningClasses.Exercises.Google;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Kid>kids;
    private  List<Pokemon>pokemons;
public Person(){
    this.parents = new ArrayList<>();
    this.kids = new ArrayList<>();
    this.pokemons = new ArrayList<>();
}
    public Person(Company company, Car car, List<Parents> parents, List<Kid> kids, List<Pokemon> pokemons) {
        this.company = company;
        this.car = car;
        this.parents = parents;
        this.kids = kids;
        this.pokemons = pokemons;
    }

    public void setCompany(Company company) {
    this.company = company;
    }

    public List<Pokemon> getPokemons() {
    return this.pokemons;
    }

    public List<Parents> getParents() {
    return this.parents;
    }

    public List<Kid> getKids() {
    return this.kids;
    }

    public void setCars(Car car) {
    this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Company:").append("\n");
        if (company!= null){
            builder.append(company).append("\n");
        }
        builder.append("Car:").append("\n");
        if (car != null){
            builder.append(car).append("\n");
        }
        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemons) {
            builder.append(pokemon).append("\n");
        }
        builder.append("Parents:").append("\n");
        for (Parents parent : parents) {
            builder.append(parent).append("\n");
        }
        builder.append("Children:").append("\n");
        for (Kid kid : kids) {
            builder.append(kid).append("\n");

        }return builder.toString();
    }
}
