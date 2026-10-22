package BinarySearch;

public class Basic {
    int binarySearch (int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (target > arr[mid]) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    int getlowerBound (int arr[], int target) {
        int start = 0;
        int end = arr.length-1;
        int ans = arr.length;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] >= target) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }

    int getUpperBound (int arr[], int target) {
        int start = 0;
        int end = arr.length;
        int ans = arr.length;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] > target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    int noOfOcuurances (int nums[], int target) {
        if (nums == null || nums.length == 0) return 0;

        int lStart = 0;
        int lEnd = nums.length-1;
        int lower = nums.length;
        while (lStart <= lEnd) {
            int mid = lStart + (lEnd - lStart)/2;

            if (nums[mid] >= target) {
                lower = mid;
                lEnd = mid - 1;
            } else {
                lStart = mid + 1;
            }
        }

        int uStart = 0;
        int uEnd = nums.length-1;
        int upper = nums.length;
        while (uStart <= uEnd) {
            int mid = uStart + (uEnd - uStart)/2;

            if (nums[mid] > target) {
                upper = mid;
                uEnd = mid - 1;
            } else {
                uStart = mid + 1;
            }
        }
        return upper-lower;
    }

    int peakOfMountain (int arr[]) {
        int s = 0;
        int e = arr.length-1;
        int ans = -1;

        while (s < e) {
            int mid = s + (e-s)/2;

            if (arr[mid] < arr[mid+1]) {
                s = mid + 1;
            }
            else {
                ans = mid;
                e = mid - 1;
            }
        }
        return ans;
    }

    int pivotIndexRotatedSortedArray (int arr[]) {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = -1;

        if (arr[0] < arr[n-1]) return -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (arr[mid] <= arr[n-1]) {
                end = mid - 1;
            }
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    void main () {
        int arr[] = {10,20,30,40,50,60};
        System.out.println(noOfOcuurances(arr, 30));
    }
}