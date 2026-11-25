class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int target = n / 4;

        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        if (freq['Q'] <= target &&
            freq['W'] <= target &&
            freq['E'] <= target &&
            freq['R'] <= target) {
            return 0;
        }

        int left = 0;
        int minLength = n;

        for (int right = 0; right < n; right++) {

            freq[s.charAt(right)]--;
            
            while (freq['Q'] <= target &&
                   freq['W'] <= target &&
                   freq['E'] <= target &&
                   freq['R'] <= target) {

                minLength = Math.min(minLength, right - left + 1);

                freq[s.charAt(left)]++;
                left++;
            }
        }

        return minLength;
    }
}
