package BinarySearch;

public class Sqrt {
    // BRUTEFORCE
    // T.C. - O(N) & S.C. - O(1)
    int bruteForce (int num) {
        if (num == 0 || num == 1) return num;
        
        int ans = -1;
        
        for (int i=1; i<=num/i; i++) {
            ans = i;
        }
        return -1;
    }

    // OPTIMAL
    // T.C. - O(LogN) & S.C. - O(1)
    int optimal (int num) {
        if (num == 0 || num == 1) return num;

        int s = 2;
        int e = num/2;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (mid <= num/mid) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }
}
