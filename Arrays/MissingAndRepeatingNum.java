package Arrays;

public class MissingAndRepeatingNum {
    // BRUTEFORCE
    // T.C. - O(N**2)
    // S.C. - O(1)
    int[] bruteForce (int nums[]) {
        int n = nums.length;
        int missing = -1;
        int repeating = -1;

        for (int i=1; i<=n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                if (nums[j] == i) count++;
            }

            if (count == 2) repeating = i;
            if (count == 0) missing = i;
        }
        return new int[]{repeating, missing};
    }

    // BETTER - USING HASHING
    // T.C. - O(2N)
    // S.C. - O(N)
    int[] better (int nums[]) {
        int n = nums.length;
        int missing = -1;
        int repeating = -1;
        int hash[] = new int[n+1];

        for (int i=0; i<n; i++) {
            hash[nums[i]]++;
        }

        for (int i=1; i<=n; i++) {
            if (hash[i] == 2) repeating = i;
            if (hash[i] == 0) missing = i;

            if (repeating != -1 && missing != -1) break;
        }

        return new int[]{repeating, missing};
    }

    // OPTIMAL
    // T.C. - 
    // S.C. - 
    int[] optimal (int nums[]) {
        int n = nums.length;
        int repeating = -1;
        int missing = -1;

        return new int[]{repeating, missing};
    }
}
