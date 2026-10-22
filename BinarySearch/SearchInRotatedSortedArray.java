package BinarySearch;

public class SearchInRotatedSortedArray {
    // [4,5,6,7,0,1,2,3]
    int search (int nums[], int target) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int pivot = pivotIndex(nums);

        if (pivot == -1) {
            return binarySearch(nums, 0, n-1, target);
        }

        int sPart1 = 0;
        int ePart1 = pivot;

        int sPart2 = pivot+1;
        int ePart2 = n-1;

        if (target >= nums[sPart1] && target <= nums[ePart1]) {
            return binarySearch(nums, sPart1, ePart1, target);
        } else {
            return binarySearch(nums, sPart2, ePart2, target);
        }
    }

    int pivotIndex (int nums[]) {
        int n = nums.length;
        int s = 0;
        int e = n-1;
        int ans = -1;

        if (nums[0] < nums[n-1]) return -1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (nums[mid] <= nums[n-1]) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }
        return ans;
    }

    int binarySearch (int nums[], int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int optimal (int nums[], int target) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int start = 0;
        int end = n-1;
        
        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) return mid;

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } 
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}