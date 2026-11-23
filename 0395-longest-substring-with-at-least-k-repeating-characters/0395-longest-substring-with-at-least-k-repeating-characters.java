class Solution {
    public int longestSubstring(String s, int k) {

        int n = s.length();
        int ans = 0;

        for (int target = 1; target <= 26; target++) {

            int[] freq = new int[26];

            int left = 0;
            int right = 0;

            int unique = 0;
            int countK = 0;

            while (right < n) {
                if (unique <= target) {

                    int idx = s.charAt(right) - 'a';

                    if (freq[idx] == 0) {
                        unique++;
                    }

                    freq[idx]++;

                    if (freq[idx] == k) {
                        countK++;
                    }

                    right++;
                }

                else {

                    int idx = s.charAt(left) - 'a';

                    if (freq[idx] == k) {
                        countK--;
                    }

                    freq[idx]--;

                    if (freq[idx] == 0) {
                        unique--;
                    }

                    left++;
                }

                if (unique == target && unique == countK) {
                    ans = Math.max(ans, right - left);
                }
            }
        }

        return ans;
    }
}
