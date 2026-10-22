package Methods;
import java.util.Scanner;

public class Functions {
    int Multiplication (int x, int y) {
        int Ans = x * y;
        return Ans;
    }

    void Table () {
        for (int i = 1; i <= 25; i++) {
            System.out.println(15+"*"+i+"="+(15*1));
        }
    }

    void printWelcomeMessage () {
        System.out.println("Hello, Welcome to my Place!");
    }

    int Addition (int a, int b) {
        int ans = a + b;
        return ans;
    }

    void ISeven(Scanner sc) {
        while (true) {
            int num = sc.nextInt();

            if (num == 7) {
                System.out.println("You guessed it correctly");
                break;
            } else {
                System.out.println("Please try again guessing a number from 1 to 20");
            }
        }
    }

    int calculatePercentage(int obtainedMarks, int totalMarks) {
        int Percentage = (obtainedMarks * 100)/totalMarks;
        return Percentage;
    }

    void maxNum (int a, int b) {
        if (a > b) {
            System.out.println(a + " is greater than " + b);
        } else {
            System.out.println(b + " is greater than " + a);
        }
    }

    void Display (int age) {
        System.out.println(age);
    }

    void Display (String name) {
        System.out.println(name);
    }

    void UpdateValue (int num) {
        System.out.println("Num in UpdateValue : " + num);
        num *= 25;
        System.out.println("Num in UpdateValue : " + num);
    }

    void main() {
        Scanner sc = new Scanner(System.in);

        // System.out.println(Multiplication(75, 25));
        // Table();
        // printWelcomeMessage();
        // System.out.println(Addition(4, 25));

        // System.out.println("Enter number between 1 to 20 to guess");
        // ISeven(sc);
        // sc.close();

        // maxNum(25, 4);
        // int obtainedMarks = 520;
        // int totalMarks = 600;
        // System.out.println(calculatePercentage(obtainedMarks, totalMarks));

        int age1 = 24;
        String name1 = "Harsh Jaiswal";
        Display(age1);
        Display(name1);

        UpdateValue(age1);
        System.out.println("Age in Main : " + age1);
    }
}