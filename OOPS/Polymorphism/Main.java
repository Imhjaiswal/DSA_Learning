package OOPS.Polymorphism;

public class Main {
    public static void main(String[] args) {
        // Calculator c = new Calculator();
        // System.out.println(c.add(4,7));
        // System.out.println(c.add(4,7,4.7,7));
        // System.out.println(c.add(4,7,2));


        // FUNCTION OVERIDDING:
        Circle c = new Circle();
        c.draw();
        doDrawing(c);


        Rectangle r = new Rectangle();
        r.draw();
        doDrawing(r);

        // HERE, draw() method as polymorphic as it is working differently for differrent shapes
    }

    // DYNAMIC METHOD DIAPATCH:
    public static void doDrawing(Shape s) {
        s.draw(); // POLYMORPHIC
    }
}
