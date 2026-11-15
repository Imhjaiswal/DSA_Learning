package GreedyAlgorithm;

public class LemonadeChange {
    // OPTIMAL
    // T.C. - O(N) & S.C. - O(1)
    boolean returnChange (int bills[]) {
        if (bills == null || bills.length == 0) return true;

        int five = 0;
        int ten = 0;

        for (int i=0; i<bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }
            else if (bills[i] == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            }
            else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
