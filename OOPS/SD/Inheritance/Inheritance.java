package OOPS.SD.Inheritance;

import java.util.List;

class Car {
    protected String brand;
    protected String model;
    protected boolean isEngineOn = false;
    protected int currentSpeed = 0;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        isEngineOn = false;
        currentSpeed = 0;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println("Engine started");
    }

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println("Start engine first");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Current Speed : " + currentSpeed);
    }

    public void brake() {
        currentSpeed -= 20;
        System.out.println("Brake Applied");
        System.out.println("Current Speed : "+currentSpeed);
    }

    public void stopEngine() {
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println("Engine turned off");
    }
}

class ManualCar extends Car {
    private int currentGear;

    ManualCar (String brand, String model) {
        super(brand, model);
        this.currentSpeed = 0;
    }

    void shiftGear (int gear) {
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }
}

class ElectricCar extends Car {
    private int batteryLevel;
    
    public ElectricCar (String brand, String model) {
        super(brand, model);
        this.batteryLevel = 100;
    }

    public void chargeBattery () {
        batteryLevel = 100;
        System.out.println(brand + " " + model + " : Battery fully charged!");
    }
}

public class Inheritance {
    void main () {
        ManualCar mCAr = new ManualCar("MG", "Hector");
        mCAr.startEngine();
        mCAr.shiftGear(1);
        mCAr.accelerate();
        mCAr.shiftGear(2);
        mCAr.accelerate();
        mCAr.brake();
        mCAr.stopEngine();

        System.out.println();

        ElectricCar evCAr = new ElectricCar("Mahindra", "XEV9S");
        evCAr.startEngine();
        evCAr.startEngine();
        evCAr.accelerate();
        evCAr.accelerate();
        evCAr.brake();
        evCAr.stopEngine();
        evCAr.chargeBattery();
    }
}