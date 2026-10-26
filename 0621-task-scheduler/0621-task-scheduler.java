class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int time = 0;

        while (true) {
            Arrays.sort(freq);
            int executed = 0;

            for (int i = 25; i >= 0 && executed <= n; i--) {
                if (freq[i] == 0) {
                    break;
                }

                freq[i]--;
                executed++;
                time++;
            }

            if (Arrays.stream(freq).sum() == 0) {
                return time;
            }

            time += (n + 1 - executed);
        }
    }
}