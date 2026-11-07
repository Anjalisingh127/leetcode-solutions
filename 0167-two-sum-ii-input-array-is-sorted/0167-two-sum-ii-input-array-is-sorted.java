class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            int remaining = target - numbers[i];

            int low = i + 1;
            int high = n - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (numbers[mid] == remaining) {
                    return new int[]{i + 1, mid + 1};
                } 
                else if (numbers[mid] < remaining) {
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }
        }

        return new int[]{};
    }
}