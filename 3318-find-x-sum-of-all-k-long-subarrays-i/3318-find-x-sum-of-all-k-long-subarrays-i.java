class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                if (!map.get(a).equals(map.get(b))) {
                    return map.get(b) - map.get(a);
                }
                return b - a;
            });

            pq.addAll(map.keySet());

            int sum = 0;

            for (int j = 0; j < x && !pq.isEmpty(); j++) {
                int num = pq.poll();
                sum += num * map.get(num);
            }

            ans[i] = sum;
        }

        return ans;
    }
}