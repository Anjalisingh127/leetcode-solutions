class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int count = 0;
                StringBuilder subarray = new StringBuilder();

                for (int l = i; l <= j; l++) {
                    if (nums[l] % p == 0) {
                        count++;
                    }
                    subarray.append(nums[l]).append(",");
                }

                if (count <= k) {
                    set.add(subarray.toString());
                }
            }
        }

        return set.size();
    }
}