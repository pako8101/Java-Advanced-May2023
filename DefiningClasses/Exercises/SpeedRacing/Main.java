package DefiningClasses.Exercises.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Cars> car = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] carData = scanner.nextLine().split(" ");
            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelConsumptionPer1km = Double.parseDouble(carData[2]);
            Cars cars = new Cars(model, fuelAmount, fuelConsumptionPer1km);
            car.put(model, cars);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split(" ");
            String model = commandParts[1];
            int distance = Integer.parseInt(commandParts[2]);
            Cars carToDrive = car.get(model);

            carToDrive.drive(distance);
            command = scanner.nextLine();
        }
        car.values().forEach(System.out::println);
    }
}
