class Solution {
    public int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] freq = new int[10];

        for (char c : arr) {
            freq[c - '0']++;
        }

        int ans = 0;

        for (char c : arr) {
            int d = (c - '0') % 2;

            for (int i = 9; i >= 0; i--) {
                if (freq[i] > 0 && i % 2 == d) {
                    ans = ans * 10 + i;
                    freq[i]--;
                    break;
                }
            }
        }

        return ans;
    }
}