package Arrays;

public class MaximumSubArraySum {
    // BRUTEFORCE
    int bruteForce (int nums[]) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int sum = 0;
                for (int k=i; k<=j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // BETTER
    int better (int nums[]) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // OPTIMAL
    int kadanes (int nums[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];

            maxSum = Math.max(maxSum, sum);

            if (sum < 0) sum = 0;
        }
        return maxSum;
    }

    // BRUTEFORCE - RETURNING SUB-ARRAY
    int[] bruteForce2 (int nums[]) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int sum = 0;
                for (int k=i; k<=j; k++) {
                    sum += nums[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    start = i;
                    end = j;
                }
            }
        }

        return java.util.Arrays.copyOfRange(nums, start, end+1);
    }

    // BETTER - RETURNING SUB-ARRAY
    int[] better2 (int nums[]) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += nums[j];

                if (sum > maxSum) {
                    maxSum = sum;
                    start = i;
                    end = j;
                }
            }
        }

        return java.util.Arrays.copyOfRange(nums, start, end+1);
    }

    // OPTIMAL - RETURNING SUB-ARRAY
    int[] kadanes2 (int nums[]) {
        int n = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;

        for (int i=0; i<n; i++) {
            if (sum == 0) start = i;

            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return java.util.Arrays.copyOfRange(nums, ansStart, ansEnd+1);
    }
}
