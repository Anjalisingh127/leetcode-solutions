class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        int[] temp = nums.clone();
        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = n - 1; i >= n - k; i--) {
            map.put(temp[i], map.getOrDefault(temp[i], 0) + 1);
        }

        int idx = 0;
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) > 0) {
                ans[idx++] = num;
                map.put(num, map.get(num) - 1);
                if (idx == k) {
                    break;
                }
            }
        }

        return ans;
    }
}