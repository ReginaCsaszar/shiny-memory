import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Truck extends Vehicle {

    private int breakdownTurnsLeft = 0;
    private final static int BREAK_CHANCE = 5;


    private static Set<String> usedTruckNameNumbers = new HashSet<>();

    Truck() {
        this.name = generateName();
        this.distanceTraveled = 0;
        this.normalSpeed = 100;
        this.currentSpeed = this.normalSpeed;
    }

    private String generateName() {
        Random randomizes = new Random();
        String truckNameNumber;
        do {
            truckNameNumber = "" + (randomizes.nextInt(1000) + 1);
        } while (usedTruckNameNumbers.contains(truckNameNumber));
        usedTruckNameNumbers.add(truckNameNumber);
        return truckNameNumber;

    }

    void checkSpeed() {
        switch (breakdownTurnsLeft) {
            case 0:
                if (currentSpeed == 0) currentSpeed = normalSpeed;
                break;
            case 1:
                breakdownTurnsLeft = 0;
                currentSpeed = normalSpeed;
                break;
            default:
                breakdownTurnsLeft--;
                break;
        }

    }

    void setCurrentSpeed() {
        boolean isBroken = tryToBreak();
        if (isBroken) {
            currentSpeed = 0;
            breakdownTurnsLeft += 2;
        }
    }

    private boolean tryToBreak(){
        Random randomizes = new Random();
        return randomizes.nextInt(100) < BREAK_CHANCE;
    }

}
