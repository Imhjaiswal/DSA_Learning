package Maths;

import java.net.Socket;

public class MathsDSA {
    // Print digits of number seperately
    static void printDigits(int num) {
        while (num != 0) {
            int digit = num % 10;
            System.out.println(digit);
            num /= 10;
        }
    }

    // Count digits of a number
    static int countDigits (int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    // Sum of digits of a number
    static int sumOfNum (int num) {
        int sum = 0;

        while (num != 0) {
            int digit = num % 10;
            num /= 10;
            sum += digit;
        }
        return sum;
    }

    // Reverse a number
    static int reverseNum (int num) {
        int revNum = 0;
        while (num != 0) {
            int digit = num % 10;
            revNum = (revNum * 10) + digit;
            num /= 10;
        }
        return revNum;
    }

    static void isNumPalindrome (int num) {
        int originalNum = num;
        int revNum = 0;

        while (num != 0) {
            int digit = num % 10;
            revNum = revNum * 10 + digit;
            num /= 10;
        }

        if (originalNum == revNum) {
            System.out.println(originalNum + " is a Palindrome number");
        } else {
            System.out.println(originalNum + " is not a Palindrome number");
        }
    }

    static boolean isPrimeNum (int num) {
        // Brute Force Approach
        // for (int i = 2; i < num - 1; i++) {
        //     if (num % i == 0)  {
        //         return false;
        //     }
        // }
        // return true;

        // Optimized Approach
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // HCF (Highest Common Factor)
    // There is already an Algorithm for finding HCF i.e. Euclidien Agorithm
    static int getGCD (int a, int b) {
        // gcd(a,b) = gcd(b, a%b);
        // until a%b becomes 0
        while (b != 0) {
            int oldValOfb = b;
            b = a % b;
            a = oldValOfb;
        }
        int gcd = a;
        return gcd;
    }

    // LCM 
    // LCM * HCF = A * B
    // LCM = (A * B) / HCF
    static int getLCM (int a, int b) {
        int lcm = (a * b) / getGCD(a, b);
        return lcm;
    }

    // Armstrong Number
    // 153 = (1)^3 + (5)^3 + (3)^3 --cubes
    // 153 = 1 + 125 + 27 = 153
    static boolean checkArmstrongNum (int num) {
        int sum = 0;
        int originalNum = num;

        while (num != 0) {
            int digit = num % 10;
            int cubeOfDigit = digit*digit*digit;
            sum += cubeOfDigit;

            num /= 10;
        }
        if (originalNum == sum) {
            return true;
        }
        return false;
    }

    // FIND DIVISORS OR PERFECT NUMBER
    // 6 = 1 + 2 + 3 
    // All divisors of a number should be equal to number
    static boolean perfectNum (int num) {
        int sum = 1;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                int firstFactor = i;
                int secondFactor = num / i;
                sum += firstFactor + secondFactor;
            }
        }
        if (sum == num) {
            return true;
        }
        return false;
    }

    // print all prime numbers till N
    static void printPrimeNumtTillN (int n) {
        for (int i = 2; i <= n; i++) {
            boolean isPrime = isPrimeNum(i);
            if (isPrime == true) {
                System.out.println(i);
            }
        }
    }

    static void main (String[]args) {
        int num = 154602;
        int num2 = 254453; 
        int num3 = 53;
        int num4 = 18;
        int num5 = 12;
        int num6 = 153;
        int num7 = 6;

        // printDigits(num);

        // System.out.println(countDigits(num));;

        // System.out.println(sumOfNum(num));

        // System.out.println(reverseNum(num));

        // isNumPalindrome(num);
        // isNumPalindrome(num2);

        // System.out.println(isPrimeNum(num));
        // System.out.println(isPrimeNum(num2));
        // System.out.println(isPrimeNum(num3));

        // System.out.println(getGCD(num2,num));
        // System.out.println(getGCD(num2,num3));
        // System.out.println(getGCD(num,num3));
        // 
        // System.out.println(getLCM(num2,num));
        // System.out.println(getLCM(num2,num3));
        // System.out.println(getLCM(num,num3));
        // System.out.println(getLCM(num4,num5));

        // System.out.println(checkArmstrongNum(num));
        // System.out.println(checkArmstrongNum(num2));
        // System.out.println(checkArmstrongNum(num3));
        // System.out.println(checkArmstrongNum(num4));
        // System.out.println(checkArmstrongNum(num5));
        // System.out.println(checkArmstrongNum(num6));

        // System.out.println(perfectNum(num));
        // System.out.println(perfectNum(num2));
        // System.out.println(perfectNum(num3));
        // System.out.println(perfectNum(num4));
        // System.out.println(perfectNum(num5));
        // System.out.println(perfectNum(num6));
        // System.out.println(perfectNum(num7));

        printPrimeNumtTillN(100);
    }
}