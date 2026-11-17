class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) return ans;

        for (int i = 0; i <= n - m; i++) {

            int[] freq1 = new int[26];
            int[] freq2 = new int[26];

            for (int j = 0; j < m; j++) {
                freq1[p.charAt(j) - 'a']++;
            }

            for (int j = i; j < i + m; j++) {
                freq2[s.charAt(j) - 'a']++;
            }

            if (Arrays.equals(freq1, freq2)) {
                ans.add(i);
            }
        }

        return ans;
    }
}
