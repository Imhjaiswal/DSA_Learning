package Recursion;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> validPalindrome (String str) {
        List<List<String>> list = new ArrayList<>();
        
        solve(0, str, list, new ArrayList<>());

        return list;
    }

    void solve (int index, String str, List<List<String>> list, List<String> current) {
        if (index == str.length()) {
            list.add(new ArrayList<>(current));
            return;
        }

        for (int i=index; i<str.length(); i++) {
            if(isPalindrome(str, index, i)) {
                // TAKE
                current.add(str.substring(index, i+1));
                solve(i+1, str, list, current);
                // BACKTRACK
                current.remove(current.size()-1);
            }
        }
    }

    boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}