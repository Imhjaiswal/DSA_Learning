package BinarySearch;

public class BSonPatterns {
    int Patterns (int num) {
        int start = 0;
        int end = num;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if ((long)mid*mid <= num) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }

    double PatternsForPrecision (double num) {
        int start = 0;
        int end = (int)num;
        double ans = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if ((long)mid*mid <= num) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        double factor = 1;
        int precision = 4;

        for (int round=1; round<=precision; round++) {
            factor /= 10;

            for (int i=1; i<=10; i++) {
                double newAns = ans + factor;

                if (newAns*newAns < num) {
                    ans = newAns;
                }
                else {
                    break;
                }
            }
        }
        return ans;
    }
}