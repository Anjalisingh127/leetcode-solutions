class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {

                int remaining = target - nums[i] - nums[j];

                int low = j + 1;
                int high = n - 1;

                while (low <= high) {
                    int mid = low + (high - low) / 2;

                    int sum = nums[i] + nums[j] + nums[mid];

                    if (Math.abs(sum - target) <
                        Math.abs(closestSum - target)) {
                        closestSum = sum;
                    }

                    if (sum < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return closestSum;
    }
}