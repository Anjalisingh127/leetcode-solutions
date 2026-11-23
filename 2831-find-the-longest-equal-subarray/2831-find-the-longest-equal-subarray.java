class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int right = 0; right < nums.size(); right++) {

            int num = nums.get(right);

            map.put(num, map.getOrDefault(num, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(num));

            while ((right - left + 1) - maxFreq > k) {
                int leftNum = nums.get(left);

                map.put(leftNum, map.get(leftNum) - 1);

                left++;
            }

            ans = Math.max(ans, maxFreq);
        }

        return ans;
    }
}
