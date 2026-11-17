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

        if (Arrays.stream(freq).allMatch(x -> x == 0)) {
            ans.add(0);
        }

        for (int i = m; i < n; i++) {

            freq[s.charAt(i - m) - 'a']++;
            freq[s.charAt(i) - 'a']--;

            if (Arrays.stream(freq).allMatch(x -> x == 0)) {
                ans.add(i - m + 1);
            }
        }

        return ans;
    }
}
