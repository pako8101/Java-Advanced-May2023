package DefiningClasses.Exercises.SpeedRacing;

public class Cars {
    private String model;
    private double fuelAmount;
    private  double fuelConsumptionPer1km;
    private int travelDistance;
    public Cars(String model, double fuelAmount, double fuelConsumptionPer1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPer1km = fuelConsumptionPer1km;
        this.travelDistance = 0;
    }
    public  double calculateRequiredFuel(int distance){
        return this.getFuelConsumptionPer1km() * distance;
    }
    public boolean hasEnoughFuel (int distance){
        return  fuelAmount >= calculateRequiredFuel(distance);
    }
    public void drive(int  distance){
        if (hasEnoughFuel(distance)){
            this.fuelAmount -= calculateRequiredFuel(distance);
            this.travelDistance += distance;
        }else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
    public void setTravelDistance(int travelDistance) {
        this.travelDistance = travelDistance;
    }

    public int getTravelDistance() {
        return travelDistance;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelConsumptionPer1km(double fuelConsumptionPer1km) {
        this.fuelConsumptionPer1km = fuelConsumptionPer1km;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelConsumptionPer1km() {
        return fuelConsumptionPer1km;
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %d", model,fuelAmount,travelDistance);
    }
}
