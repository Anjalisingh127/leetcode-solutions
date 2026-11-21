class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int left = 0;
        int freq = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == max) {
                freq++;
            }

            while (freq >= k) {
                if (nums[left] == max) {
                    freq--;
                }
                left++;
            }

            count += left;
        }

        return count;
    }
}
