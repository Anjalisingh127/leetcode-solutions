class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        TreeMap<Long, Integer> map = new TreeMap<>();

        long minSum = Long.MAX_VALUE;

        for (int j = l; j <= n; j++) {

            long add = prefix[j - l];
            map.put(add, map.getOrDefault(add, 0) + 1);

            int removeIndex = j - r - 1;

            if (removeIndex >= 0) {
                long remove = prefix[removeIndex];

                if (map.get(remove) == 1) {
                    map.remove(remove);
                } else {
                    map.put(remove, map.get(remove) - 1);
                }
            }

            Long key = map.lowerKey(prefix[j]);

            if (key != null) {
                minSum = Math.min(minSum, prefix[j] - key);
            }
        }

        return minSum == Long.MAX_VALUE ? -1 : (int) minSum;
    }
}
