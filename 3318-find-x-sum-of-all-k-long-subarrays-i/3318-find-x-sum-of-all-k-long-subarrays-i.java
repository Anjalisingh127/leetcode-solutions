class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            List<Integer> list = new ArrayList<>(freq.keySet());

            list.sort((a, b) -> {
                int fa = freq.get(a);
                int fb = freq.get(b);

                if (fa != fb) {
                    return fb - fa;
                }
                return b - a;
            });

            int sum = 0;
            for (int j = 0; j < Math.min(x, list.size()); j++) {
                int num = list.get(j);
                sum += num * freq.get(num);
            }

            ans[i] = sum;

            if (i + k < n) {
                int outgoing = nums[i];
                int incoming = nums[i + k];

                freq.put(outgoing, freq.get(outgoing) - 1);
                if (freq.get(outgoing) == 0) {
                    freq.remove(outgoing);
                }

                freq.put(incoming, freq.getOrDefault(incoming, 0) + 1);
            }
        }

        return ans;
    }
}