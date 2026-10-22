package Arrays;

public class MaxProdSubArray {
    int bruteforce (int nums[]) {
        int n = nums.length;
        int maxProd = 1;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int prod = 1;
                for (int k=i; k<=n; k++) {
                    prod *= nums[k];
                }
                maxProd = Math.max(maxProd, prod);
            }
        }

        return maxProd;
    }

    int better (int nums[]) {
        int n = nums.length;
        int maxProd = 1;

        for (int i=0; i<n; i++) {
            int prod = 1;
            for (int j=i; j<n; j++) {
                prod *= nums[j];
                maxProd = Math.max(maxProd, prod);
            }
        }

        return maxProd;
    }

    int optimal (int nums[]) {
        int n = nums.length;
        int pre = 1;
        int suff = 1;
        int maxProd = 1;

        for (int i=0; i<n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;

            pre *= nums[i];
            suff *= nums[n-1-i];

            maxProd = Math.max(maxProd, Math.max(pre, suff));
        }
        return maxProd;
    }
}
