class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        int start = -1, end = -1;

        int max = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
        }

        int min = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > min) {
                start = i;
            } else {
                min = nums[i];
            }
        }

        if (start == -1) {
            return 0;
        }

        return end - start + 1;
    }
}