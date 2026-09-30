class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longest = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if ((long) nums[i] == (long) nums[i - 1] + 1) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            longest = Math.max(longest, currentLength);
        }

        return longest;
    }
}