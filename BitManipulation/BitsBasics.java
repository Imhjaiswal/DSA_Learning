package BitManipulation;

import javax.sound.sampled.SourceDataLine;

public class BitsBasics {
    void oddOrEven (int n) {
        if ((n & 1) == 0) {
            System.out.println(n+" is even number");
        } else {
            System.out.println(n+" is odd number");
        }
    }
    int getIthBit (int n,int i) {
        if ((n & (1<<i)) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    int setIthBit (int n, int i) {
        return n | (1 << i);
    }
    int clearIthBit (int n, int i) {
        return (n & ~(1<<i));
    }
    int updateIthBit (int n, int i, int newBit) {
        if (newBit == 0) {
            return clearIthBit(n,i);
        } else {
            return setIthBit(n,i);
        }
    }
    int clearLastIBits (int n, int i) {
        return n & ((~0)<<i);
    }
    int clearRangeOfBits (int n, int start, int end) {
        int a = (~0) << (end+1);
        int b = (1<<start)-1;
        return n & (a|b);
    }
    void powerOf2 (int n) {
        if ((n & (n-1)) == 0) {
            System.out.println(n+" is power of 2");
        } else {
            System.out.println(n+" is not power of 2");
        }
    }

    void main(String[] args) {
        // oddOrEven(5);
        // oddOrEven(55);
        // oddOrEven(10);
        // oddOrEven(100);

        // System.out.println(getIthBit(500, 3));
        // System.out.println(getIthBit(10, 2));
        // System.out.println(getIthBit(10, 3));

        // System.out.println(setIthBit(10,2));

        // System.out.println(clearIthBit(10,3));
        // System.out.println(clearIthBit(10,1));

        // System.out.println(updateIthBit(10, 2, 0));
        // System.out.println(updateIthBit(10, 2, 1));

        System.out.println(clearLastIBits(15,2));

        powerOf2(128);
        powerOf2(1248);
    }
}
