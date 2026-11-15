class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        int count = 0;

        for (int x : freq) {
            if (x != 0) count++;
        }

        if (count == 0) return true;

        for (int i = n; i < m; i++) {

            int add = s2.charAt(i) - 'a';
            int remove = s2.charAt(i - n) - 'a';

            if (freq[add] == 1) count--;
            else if (freq[add] == 0) count++;

            freq[add]--;

            if (freq[remove] == -1) count--;
            else if (freq[remove] == 0) count++;

            freq[remove]++;

            if (count == 0) return true;
        }

        return false;
    }
}