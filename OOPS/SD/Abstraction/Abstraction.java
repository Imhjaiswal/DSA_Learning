package OOPS.SD.Abstraction;

public class Abstraction {
    static void main () {
        Car myCar = new SportsCar("Hyundai", "Venue");

        myCar.startEngine();
        myCar.shiftgear(1);
        myCar.accelerate();
        myCar.shiftgear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();
    }
}

interface Car {
    public void startEngine();
    public void shiftgear(int gear);
    public void accelerate();
    public void brake();
    public void stopEngine();
}

class SportsCar implements Car {
    String brand;
    String model;
    boolean isEngineOn = false;
    int currentSpeed = 0;
    int currentGear = 0;

    SportsCar (String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine start with roar!");
    }

    public void shiftgear(int gear) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off, cannot shift gear.");
            return ;
        }
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : shifted to gear " + currentGear);
    }

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off, cannot shift gear.");
            return ;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + "km/h");
    }

    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand+" "+model+" : Braking! Speed is now " + currentSpeed + " km/h");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : engine turned Off.");
    }
}