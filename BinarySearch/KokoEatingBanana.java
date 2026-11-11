package BinarySearch;

public class KokoEatingBanana {
    // BRUTEFORCE
    // T.C. - O(M * N) -- M : max element in array
    // S.C.- 
    int bruteforce (int nums[], int hours) {
        if (nums == null || nums.length == 0) return -1;

        int maxNum = Integer.MIN_VALUE;
        for (int num: nums) {
            maxNum = Math.max(maxNum, num);
        }

        for (int i=1; i<=maxNum; i++) {
            int requiredTime = calculateMinTime(nums, i);
            if (requiredTime <= hours) {
                return i;
            }
        }
        return -1;
    }

    int calculateMinTime (int nums[], int speed) {
        int totalHours = 0;

        for (int i=0; i<nums.length; i++) {
            totalHours += (nums[i] + speed - 1)/speed;
        }

        return totalHours;
    }

    // OPTIMAL
    // T.C. - O(N logM) & S.C.- O(1)
    int optimal (int nums[], int hours) {
        if (nums == null || nums.length == 0) return -1;

        int maxNum = Integer.MIN_VALUE;

        for (int num: nums) {
            maxNum = Math.max(maxNum, num);
        }

        int s = 1;
        int e = maxNum;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            int requiredTime = calculateMinTime(nums, mid);

            if (requiredTime <= hours) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}
