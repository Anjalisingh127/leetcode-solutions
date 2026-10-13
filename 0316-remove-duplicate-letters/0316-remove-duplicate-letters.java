
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']--;

            if (seen[ch - 'a']) {
                continue;
            }

            while (result.length() > 0
                    && result.charAt(result.length() - 1) > ch
                    && freq[result.charAt(result.length() - 1) - 'a'] > 0) {

                char removed = result.charAt(result.length() - 1);
                result.deleteCharAt(result.length() - 1);
                seen[removed - 'a'] = false;
            }

            result.append(ch);
            seen[ch - 'a'] = true;
        }

        return result.toString();
    }
}
