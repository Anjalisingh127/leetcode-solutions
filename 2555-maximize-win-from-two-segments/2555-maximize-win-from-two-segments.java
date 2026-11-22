class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;

        int[] dp = new int[n + 1];

        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {

            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }

            int count = right - left + 1;

            ans = Math.max(ans, count + dp[left]);

            dp[right + 1] = Math.max(dp[right], count);
        }

        return ans;
    }
}
