class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
        }

        int[] ans = new int[nums.length];
        int i = 0;

        while (!pq.isEmpty()) {
            int alice = pq.poll();
            int bob = pq.poll();

            ans[i++] = bob;
            ans[i++] = alice;
        }

        return ans;
    }
}