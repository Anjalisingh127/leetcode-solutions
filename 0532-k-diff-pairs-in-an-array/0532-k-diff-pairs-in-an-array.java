class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Arrays.sort(nums);

        int i = 0, j = 1;
        int count = 0;
        int n = nums.length;

        while (j < n) {

            if (i == j || nums[j] - nums[i] < k) {
                j++;
            }
            else if (nums[j] - nums[i] > k) {
                i++;
            }
            else {
                count++;

                int a = nums[i];
                int b = nums[j];

                while (i < n && nums[i] == a) i++;
                while (j < n && nums[j] == b) j++;
            }
        }

        return count;
    }
}
