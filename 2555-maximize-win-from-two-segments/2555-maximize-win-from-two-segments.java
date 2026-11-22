class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;

        int[] prefix = new int[n + 1];

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int left = lowerBound(prizePositions,
                                  prizePositions[i] - k);

            int count = i - left + 1;

            ans = Math.max(ans, count + prefix[left]);

            prefix[i + 1] = Math.max(prefix[i], count);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
