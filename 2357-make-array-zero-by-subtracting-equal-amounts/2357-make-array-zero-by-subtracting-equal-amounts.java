class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[1001];
        int count = 0;

        for (int num : nums) {
            if (num > 0 && !seen[num]) {
                seen[num] = true;
                count++;
            }
        }

        return count;
    }
}