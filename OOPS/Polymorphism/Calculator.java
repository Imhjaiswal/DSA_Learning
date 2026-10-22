package OOPS.Polymorphism;

public class Calculator {
    int add (int a, int b) {
        return a+b;
    }

    // Method Overloading - "add"
    int add (int a, int b, int c) {
        return a+b+c;
    }

    double add (int a, int b, double c, double d) {
        return a+b+c+d;
    }
}
