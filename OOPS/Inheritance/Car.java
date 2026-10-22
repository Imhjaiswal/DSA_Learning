package OOPS.Inheritance;

public class Car extends Vehicle {
    public int noOfDoors;
    public String transmissionType;

    Car(String name, String model, int noOfTyres, int noOfDoors, String transmissionType) {
        super(name, model, noOfTyres);
        this.transmissionType = transmissionType;
        this.noOfDoors = noOfDoors;
    }

    public void startAC() {
        System.out.println("Start AC of "+ name + " " + model);
    }
}
