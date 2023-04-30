package DefiningClasses.Exercises.CatLady;

public class Cymric {
    private String name;
    private double furLength;

    public Cymric(String name, double furLength) {
        this.name = name;
        this.furLength = furLength;
    }

    public String getName() {
        return name;
    }

    public double getFurLength() {
        return furLength;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }
    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", name,furLength);
    }
}
