class Solution {
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        boolean[] visited = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) {
                continue;
            }

            int count = 1;

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                    visited[j] = true;
                }
            }
        }

        while (result.length() < s.length()) {
            int maxFreq = 0;
            char maxChar = '\0';

            for (int i = 0; i < s.length(); i++) {
                if (visited[i]) {
                    continue;
                }

                int count = 0;

                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        count++;
                    }
                }

                if (count > maxFreq) {
                    maxFreq = count;
                    maxChar = s.charAt(i);
                }
            }

            if (maxFreq == 0) {
                break;
            }

            for (int k = 0; k < maxFreq; k++) {
                result.append(maxChar);
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == maxChar) {
                    visited[i] = true;
                }
            }
        }

        return result.toString();
    }
}
