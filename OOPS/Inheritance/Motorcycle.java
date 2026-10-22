package OOPS.Inheritance;

public class Motorcycle extends Vehicle {
    public String suspensionType;
    public String handleBarStyle;

    Motorcycle(String name, int noOfTyres, String model, String suspensionType, String handleBarStyle) {
        super(name, model, noOfTyres);
        this.handleBarStyle = handleBarStyle;
        this.suspensionType = suspensionType;
    }
}
