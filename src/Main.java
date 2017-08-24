import java.util.ArrayList;
import java.util.Random;

public class Main {

    private final static int TOTAL_LAPS = 50;
    private final static int RAIN_CHANCE = 30;
    private final static int SPEED_LIMIT = 70;
    private final static int SPEED_LIMIT_CHANCE = 30;

    public static void main(String[] args) {
        Car.setSpeedLimit(SPEED_LIMIT);
        ArrayList<Vehicle> competitors = createVehicles();
        simulateRace(competitors);
        printRaceResults(competitors);
    }

    private static ArrayList createVehicles() {
        // creates 10 cars, 10 trucks and 10 motorcycles
        ArrayList<Vehicle> raceVehicles = new ArrayList<Vehicle>();
        for (int i = 0; i < 10; i++) {
            raceVehicles.add(new Motorcycle());
            raceVehicles.add(new Truck());
            raceVehicles.add(new Car());
        }
        return raceVehicles;
    }

    private static boolean isRaining() {
        Random randomizes = new Random();
        return randomizes.nextInt(100) < RAIN_CHANCE;
    }

    private static boolean isSpeedLimit() {
        Random randomizes = new Random();
        return randomizes.nextInt(100) < SPEED_LIMIT_CHANCE;
    }

    private static void simulateRace(ArrayList<Vehicle> racers){
        boolean raining, slowdown;
        for (int lap = 0; lap < TOTAL_LAPS; lap++) {
            raining = isRaining();
            slowdown = isSpeedLimit();
            for (Vehicle racer : racers) {
                if ((racer instanceof Car) && (slowdown)) racer.setCurrentSpeed();
                if ((racer instanceof Motorcycle) && (raining)) racer.setCurrentSpeed();
                if (racer instanceof Truck) racer.setCurrentSpeed();
                racer.moveForAnHour();
            }
        }
    }

    private static void printRaceResults(ArrayList<Vehicle> racers) {
        System.out.println("Final result:");
        for (Vehicle racer : racers) {
            System.out.print("Name: " + racer.name);
            System.out.print(", Type: " + racer.getClass());
            System.out.println(", Distance: "  + racer.distanceTraveled + " km");
        }
    }
}
