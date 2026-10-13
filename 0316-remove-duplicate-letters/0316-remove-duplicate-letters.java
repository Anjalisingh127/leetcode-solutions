class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] seen = new boolean[26];
        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) freq[c - 'a']++;

        for (char c : s.toCharArray()) {
            freq[c - 'a']--;

            if (seen[c - 'a']) continue;

            while (res.length() > 0 &&
                   res.charAt(res.length() - 1) > c &&
                   freq[res.charAt(res.length() - 1) - 'a'] > 0) {
                seen[res.charAt(res.length() - 1) - 'a'] = false;
                res.deleteCharAt(res.length() - 1);
            }

            res.append(c);
            seen[c - 'a'] = true;
        }

        return res.toString();
    }
}