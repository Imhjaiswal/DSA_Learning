package BinarySearch;

public class ekoSpoj {
    int search (int trees[], int minWood) {
        int n = trees.length;

        int start = 0;
        int end = 0;
        int ans = 0;

        for (int i=0; i<n; i++) {
            end = Math.max(end, trees[i]);
        }

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (isValidAns(trees, minWood, mid)) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }

    boolean isValidAns (int trees[], int requiredWood, int currentHeight) {
        int totalWoodCollected = 0;

        for (int i=0; i<trees.length; i++) {
            if (trees[i] > currentHeight) {
                totalWoodCollected += trees[i] - currentHeight;
            }
            if (totalWoodCollected >= requiredWood) return true;
        }
        return false;
    }
}
