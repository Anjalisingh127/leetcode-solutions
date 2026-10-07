class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        int[] text = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                text[i] = 1;
            } else if (nums[i + 1] == nums[i]) {
                text[i] = 0;
            } else {
                text[i] = -1;
            }
        }

        int[] lps = new int[m];

        for (int i = 1, len = 0; i < m; ) {
            if (pattern[i] == pattern[len]) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        // KMP search
        int count = 0;
        int i = 0;
        int j = 0;

        while (i < text.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;

                if (j == m) {
                    count++;
                    j = lps[j - 1];
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return count;
    }
}