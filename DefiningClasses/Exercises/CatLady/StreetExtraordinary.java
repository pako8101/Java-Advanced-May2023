package DefiningClasses.Exercises.CatLady;

public class StreetExtraordinary {
    private String name;
    private double decibels;

    public StreetExtraordinary(String name, double decibels) {
        this.name = name;
        this.decibels = decibels;
    }

    public String getName() {
        return name;
    }

    public double getDecibels() {
        return decibels;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDecibels(double decibels) {
        this.decibels = decibels;
    }
    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", name,decibels);
    }


}
