import java.util.Random;

public class Motorcycle extends Vehicle {

    private static int nameNumber = 0;

    Motorcycle() {
        nameNumber++;
        this.name = "Motorcycle " + nameNumber;
        this.distanceTraveled = 0;
        this.normalSpeed = 100;
        this.currentSpeed = this.normalSpeed;
    }

    void checkSpeed() {
        if (currentSpeed < normalSpeed) currentSpeed = normalSpeed;
    }

    void setCurrentSpeed() {
        Random randomizes = new Random();
        currentSpeed -= randomizes.nextInt(46) + 5;
    }
}
