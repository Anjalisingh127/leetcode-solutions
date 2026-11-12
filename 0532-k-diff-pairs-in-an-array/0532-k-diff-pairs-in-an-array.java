class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Set<Integer> set = new HashSet<>();
        Set<Integer> pairs = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num - k)) {
                pairs.add(num);
            }

            if (set.contains(num + k)) {
                pairs.add(num + k);
            }

            set.add(num);
        }

        return pairs.size();
    }
}
