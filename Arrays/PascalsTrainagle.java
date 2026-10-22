package Arrays;

public class PascalsTrainagle {
    // TYPE 1 - FIND ELEMENT AT ROW & COL
    // BRUTEFORCE
    int bruteforceOfType1 (int row, int col) {
        int r = row-1;
        int c = col-1;

        long ans = fact(r) / (fact(c) * fact(r-c));

        return (int)ans;
    }

    long fact (int n) {
        long res = 1;

        if (n == 1 || n == 0) return 1;

        for (int i=n; i>=1; i--) {
            res *= i;
        }
        return res;
    }

    // OPTIMAL
    int optimalOfType1 (int row, int col) {
        int result = 1;
        int n = row-1;
        int r = col-1;

        r = Math.min(r, n-r);

        for (int i=0; i<r; i++) {
            result *= (n-1);
            result /= (i+1);
        }
        return result;
    }

    // TYPE 2 - FIND ENTIRE ROW AT A GIVEN R
    
}
