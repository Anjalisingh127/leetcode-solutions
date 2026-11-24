class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long original = 0;

        for (int i = 0; i < n; i++) {
            original += (long) prices[i] * strategy[i];
        }

        long gain = 0;

        for (int i = 0; i < k / 2; i++) {
            gain -= (long) prices[i] * strategy[i];
        }

        for (int i = k / 2; i < k; i++) {
            gain += (long) prices[i] * (1 - strategy[i]);
        }

        long maxGain = Math.max(0, gain);

        for (int i = k; i < n; i++) {

            gain += (long) prices[i - k] * strategy[i - k];

            gain -= (long) prices[i - k / 2] *
                    (1 - strategy[i - k / 2]);

            gain -= (long) prices[i - k / 2] *
                    strategy[i - k / 2];

            gain += (long) prices[i] * (1 - strategy[i]);

            maxGain = Math.max(maxGain, gain);
        }

        return original + maxGain;
    }
}
