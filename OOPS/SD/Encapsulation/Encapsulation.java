package OOPS.SD.Encapsulation;

public class Encapsulation {
    public static void main () {
        SportsCar myCar = new SportsCar("Hyundai", "Venue");

        myCar.setTyreCompany("MRF");
        myCar.getTyreCompany();
        myCar.startEngine();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();

        // Encapsulated via Access Modifiers
        // myCar.currentSpeed = 500;
        System.out.println("Current Speed : "+myCar.getSpeed());
    }
}

class SportsCar {
    private String brand;
    private String model;
    private boolean isEngineOn = false;
    private int currentSpeed = 0;
    private int currentGear = 0;
    private String tyreCompany;

    public SportsCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public int getSpeed() {
        return currentSpeed;
    }

    public int getGear() {
        return currentGear;
    }

    public void getTyreCompany() {
        System.out.println("Tyre Company : "+tyreCompany);
    }

    public void setTyreCompany (String tyreCompany) {
        this.tyreCompany = tyreCompany;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println("Engine started");
    }

    public void shiftGear(int currentGear) {
        if (!isEngineOn) {
            System.out.println("Turn on Engine first");
            return;
        }
        this.currentGear = currentGear;
        System.out.println(brand + " " + model + " : Current Gear : " + currentGear);
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
        currentGear = 0;
        currentSpeed = 0;
        System.out.println("Engine turned off");
    }
}