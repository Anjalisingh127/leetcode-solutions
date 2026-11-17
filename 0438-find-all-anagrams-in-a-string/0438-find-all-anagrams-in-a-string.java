class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) return ans;

        int[] freq = new int[26];

        for (int i = 0; i < m; i++) {
            freq[p.charAt(i) - 'a']++;
            freq[s.charAt(i) - 'a']--;
        }

        int matches = 0;

        for (int count : freq) {
            if (count == 0) matches++;
        }

        if (matches == 26) ans.add(0);

        for (int i = m; i < n; i++) {

            int out = s.charAt(i - m) - 'a';
            int in = s.charAt(i) - 'a';

            if (freq[out] == 0) matches--;
            freq[out]++;
            if (freq[out] == 0) matches++;

            if (freq[in] == 0) matches--;
            freq[in]--;
            if (freq[in] == 0) matches++;

            if (matches == 26) {
                ans.add(i - m + 1);
            }
        }

        return ans;
    }
}
