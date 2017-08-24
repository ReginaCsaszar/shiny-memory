abstract class Vehicle {

    String name;
    int distanceTraveled;
    int normalSpeed;
    int currentSpeed;

    public String getName() {
        return name;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    void moveForAnHour() {
        distanceTraveled += currentSpeed;
        checkSpeed();
    }

    abstract void checkSpeed();
    abstract void setCurrentSpeed();

}