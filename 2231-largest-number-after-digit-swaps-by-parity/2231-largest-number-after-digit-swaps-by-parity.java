class Solution {
    public int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());

        for (char c : arr) {
            int d = c - '0';

            if (d % 2 == 0) {
                even.offer(d);
            } else {
                odd.offer(d);
            }
        }

        int ans = 0;

        for (char c : arr) {
            if ((c - '0') % 2 == 0) {
                ans = ans * 10 + even.poll();
            } else {
                ans = ans * 10 + odd.poll();
            }
        }

        return ans;
    }
}