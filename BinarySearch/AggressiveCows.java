package BinarySearch;
import java.util.Arrays;

public class AggressiveCows {
    // TC : O(N Log(N))
    // SC : O(Log(N))
    int search (int nums[], int k) {
        int n = nums.length;

        if (n==0 || n==1 || k<=1) return 0;

        Arrays.sort(nums);

        int s = 0;
        int e = nums[n-1] - nums[0];
        int ans = -1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (isValidDistribution(nums, k, mid)) {
                ans = mid;
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return ans;
    }

    boolean isValidDistribution (int nums[], int totalCows, int minDistance) {
        int cowCount = 1;
        int lastPosition = 0;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] - nums[lastPosition] >= minDistance) {
                cowCount++;
                lastPosition = i;
                
                if (cowCount == totalCows) return true;
            }
        }
        return false;
    }
}
