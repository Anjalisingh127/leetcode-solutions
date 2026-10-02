class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        int[] unique = new int[n];
        int[] freq = new int[n];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            boolean found = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (unique[j] == nums[i]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                unique[uniqueCount] = nums[i];

                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] == nums[i]) {
                        count++;
                    }
                }

                freq[uniqueCount] = count;
                uniqueCount++;
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int maxIndex = 0;

            for (int j = 1; j < uniqueCount; j++) {
                if (freq[j] > freq[maxIndex]) {
                    maxIndex = j;
                }
            }

            result[i] = unique[maxIndex];

            freq[maxIndex] = -1;
        }

        return result;
    }
}