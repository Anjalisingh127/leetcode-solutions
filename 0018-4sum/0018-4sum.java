class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                Set<Long> seen = new HashSet<>();

                for (int k = j + 1; k < n; k++) {

                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = (long) target - sum;

                    if (seen.contains(fourth)) {

                        List<Integer> temp = Arrays.asList(
                            nums[i], nums[j], nums[k], (int) fourth
                        );

                        Collections.sort(temp);
                        ans.add(temp);
                    }

                    seen.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(ans);
    }
}