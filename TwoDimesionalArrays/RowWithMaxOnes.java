package TwoDimesionalArrays;

public class RowWithMaxOnes {
    int getFirstOccuranceOfOne (int nums[][], int rowIndex) {
        int totalCol = nums[0].length;
        int ans = -1;

        if (nums[rowIndex][totalCol-1] == 0) return totalCol;
        
        int start = 0;
        int end = totalCol-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[rowIndex][mid] == 0) {
                start = mid + 1;
            }
            else {
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }

    int rowWithMax1s (int nums[][]) {
        int maxCount = 0;
        int ans = -1;

        for (int i=0; i<nums.length; i++) {
            int firstOccuranceIndex = getFirstOccuranceOfOne(nums, i);

            int count = nums[0].length - firstOccuranceIndex;
            
            if (count > maxCount) {
                ans = i;
                maxCount = count;
            }
        }
        return ans;
    }   
} 