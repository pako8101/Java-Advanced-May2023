package DefiningClasses.Exercises.CatLady;

public class Siamese {
    private  String name;
    private double earSize;

    public Siamese(String name, double earSize) {
        this.name = name;
        this.earSize = earSize;
    }

    public String getName() {
        return name;
    }

    public double getEarSize() {
        return earSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }
    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", name,earSize);
    }
}
