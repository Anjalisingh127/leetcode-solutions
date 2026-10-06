class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26 * 26];
        int count = 0;
    }

    public int countPrefixSuffixPairs(String[] words) {

        TrieNode root = new TrieNode();
        int answer = 0;

        for (String word : words) {

            TrieNode node = root;
            int n = word.length();

            for (int i = 0; i < n; i++) {

                char left = word.charAt(i);
                char right = word.charAt(n - 1 - i);

                int index = (left - 'a') * 26
                          + (right - 'a');

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];

                // Previously inserted word ends here
                answer += node.count;
            }

            // Mark this complete word
            node.count++;
        }

        return answer;
    }
}