package OOPS.Inheritance;

public class Vehicle {
    public String name;
    public String model;
    public int noOfTyres;

    public void startEngine() {
        System.out.println("Engine Start "+ name + " " + model);
    }

    public void stopEngine() {
        System.out.println("Engine Stop of"+ name + " " + model);
    }

    Vehicle() {
        this.name = "";
        this.model = "";
        this.noOfTyres = -1;
    }

    Vehicle(String name, String model, int noOfTyres) {
        this.name = name;
        this.model = model;
        this.noOfTyres = noOfTyres;
    }
}
