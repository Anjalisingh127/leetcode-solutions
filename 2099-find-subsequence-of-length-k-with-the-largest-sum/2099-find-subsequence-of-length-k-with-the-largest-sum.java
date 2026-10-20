class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0]
                ? a[0] - b[0]
                : b[1] - a[1]
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] selected = new int[k][2];
        for (int i = 0; i < k; i++) {
            selected[i] = pq.poll();
        }

        Arrays.sort(selected, (a, b) -> a[1] - b[1]);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = selected[i][0];
        }

        return ans;
    }
}