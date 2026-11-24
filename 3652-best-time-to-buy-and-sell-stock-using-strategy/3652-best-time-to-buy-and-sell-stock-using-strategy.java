class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long[] prefix1 = new long[n + 1];
        long[] prefix2 = new long[n + 1];

        long original = 0;

        for (int i = 0; i < n; i++) {
            original += (long) prices[i] * strategy[i];

            prefix1[i + 1] = prefix1[i]
                    + (long) prices[i] * strategy[i];

            prefix2[i + 1] = prefix2[i]
                    + (long) prices[i] * (1 - strategy[i]);
        }

        long maxProfit = original;

        for (int i = 0; i <= n - k; i++) {
            int mid = i + k / 2;
            int end = i + k;

            long firstHalf = prefix1[mid] - prefix1[i];

            long secondHalf = prefix2[end] - prefix2[mid];

            long profit = original - firstHalf + secondHalf;

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
