package Strings;

import java.nio.channels.Pipe.SourceChannel;

class Strings {
    // 1. Print all char of a String:
    static void printString (String str) {
        for (int i = 0; i < str.length(); i++) {
            // if (str.charAt(i) == ' ') {
            //     continue;
            // }
            System.out.println(str.charAt(i));
        }
    }

    // 2. Count length of a String without using length()
    static int lenOfStr (String str) {
        // Way 1:
        char [] arr = str.toCharArray();
        return arr.length;
    }

    // 3. Vowels in the string
    static int vowelsInStr (String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count++;
            }
        }
        return count;
    }

    // TBD again after larning StringBuilder:
    static String reverseStr (String str) {
        String reverseString = "";
        for (int i = str.length()-1; i >= 0; i-- ) {
            reverseString += str.charAt(i);
        }
        return reverseString;
    }

    // Check if string is Palindrome or not
    static boolean checkPalindromeStr (String str) {
        if (str.equalsIgnoreCase(reverseStr(str))) {
            return true;
        }
        return false;
    }

    static void main(String[] args) {
        String name = "Harsh Jaiswal";
        String palinStr = "Racecar";
        // printString(name);

        // System.out.println(lenOfStr(name));

        // System.out.println(vowelsInStr(name));
        
        // System.out.println(reverseStr(name));

        System.out.println(checkPalindromeStr(palinStr));
    }
}
