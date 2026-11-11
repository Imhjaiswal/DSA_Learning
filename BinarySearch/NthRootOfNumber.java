package BinarySearch;

public class NthRootOfNumber {
    // BRUTEFORCE
    int bruteforce (int num) {
        if (num == 0 || num == 1) return num;

        int ans = -1;

        for (int i=1; i<=num/(i*i); i++) {
            ans = i;
        }
        return ans;
    }

    // OPTIMAL
    int optimal (int num) {
        if (num == 0 || num == 1) return num;

        int s = 2;
        int e = num/3;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (mid <= num/(mid*mid)) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }
}
