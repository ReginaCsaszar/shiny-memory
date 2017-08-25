abstract class Vehicle {

    String name;
    int distanceTraveled;
    int normalSpeed;
    int currentSpeed;


    void moveForAnHour() {
        distanceTraveled += currentSpeed;
        checkSpeed();
    }

    abstract void checkSpeed();
    abstract void setCurrentSpeed();

}