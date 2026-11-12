class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) continue;

            int slow = i;
            int fast = i;
            boolean forward = nums[i] > 0;

            while (true) {

                slow = getNext(nums, slow, forward);

                if (slow == -1) break;

                fast = getNext(nums, fast, forward);

                if (fast == -1) break;

                fast = getNext(nums, fast, forward);

                if (fast == -1) break;

                if (slow == fast) {
                    return true;
                }
            }

            // Mark visited elements
            int curr = i;

            while (nums[curr] != 0 &&
                   (nums[curr] > 0) == forward) {

                int next = ((curr + nums[curr]) % n + n) % n;

                nums[curr] = 0;

                if (next == curr) break;

                curr = next;
            }
        }

        return false;
    }

    private int getNext(int[] nums, int curr, boolean forward) {
        int n = nums.length;

        if (nums[curr] == 0 ||
            (nums[curr] > 0) != forward) {
            return -1;
        }

        int next = ((curr + nums[curr]) % n + n) % n;

        if (next == curr) return -1;

        return next;
    }
}
