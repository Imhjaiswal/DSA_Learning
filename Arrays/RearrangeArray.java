package Arrays;

public class RearrangeArray {
    // BRUTEFORCE
    void bruteforce (int nums[]) {
        int n = nums.length;
        int pos[] = new int[n/2];
        int neg[] = new int[n/2];
        int p = 0;
        int q = 0;

        for (int num: nums) {
            if (num >= 0) {
                pos[p++] = num;
            } else {
                neg[q++] = num;
            }
        }

        for (int i=0; i<n/2; i++) {
            nums[2*i] = pos[i];
            nums[2*i+1] = neg[i];
        }
    }

    // OPTIMAL
    int[] optimal (int nums[]) {
        int pos = 0;
        int neg = 1;
        int n = nums.length;
        int ans[] = new int[n];

        for (int i=0; i<n; i++) {
            if (nums[i] >= 0) {
                ans[pos] = nums[i];
                pos+=2;
            }
            else {
                ans[neg] = nums[i];
                neg+=2;
            }
        }
        return ans;
    }
}
