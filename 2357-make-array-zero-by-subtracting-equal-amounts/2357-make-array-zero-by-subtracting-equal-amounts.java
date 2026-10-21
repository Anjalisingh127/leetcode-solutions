class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;

        while (true) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    min = Math.min(min, nums[i]);
                }
            }

            if (min == Integer.MAX_VALUE) {
                break;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nums[i] -= min;
                }
            }

            count++;
        }

        return count;
    }
}