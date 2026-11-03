class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Check if skipping left character works
                int l1 = left + 1, r1 = right;
                while (l1 < r1 && s.charAt(l1) == s.charAt(r1)) { l1++; r1--; }
                if (l1 >= r1) return true;
                
                // Check if skipping right character works
                int l2 = left, r2 = right - 1;
                while (l2 < r2 && s.charAt(l2) == s.charAt(r2)) { l2++; r2--; }
                return l2 >= r2;
            }
            left++;
            right--;
        }
        return true;
    }
}