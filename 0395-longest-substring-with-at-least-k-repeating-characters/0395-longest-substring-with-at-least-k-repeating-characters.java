class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {

                char ch = s.charAt(j);

                map.put(ch, map.getOrDefault(ch, 0) + 1);

                boolean valid = true;

                for (int freq : map.values()) {
                    if (freq < k) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}
