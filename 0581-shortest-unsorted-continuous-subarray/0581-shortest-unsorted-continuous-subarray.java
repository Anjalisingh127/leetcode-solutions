class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        int start = n, end = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }

            int j = n - 1 - i;

            if (nums[j] > min) {
                start = j;
            } else {
                min = nums[j];
            }
        }

        return end - start > 0 ? end - start + 1 : 0;
    }
}