package OOPS.Polymorphism;

public class Circle extends Shape {
    // @Override - no need to use manually, parent draw() will be automatically override during runtime env
    public void draw() {
        System.out.println("Circle drawing...");
    }
}
