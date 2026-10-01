class Solution {
    public boolean isSubsequence(String s, String t) {

        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            boolean found = false;

            for (int j = start; j < t.length(); j++) {

                if (s.charAt(i) == t.charAt(j)) {
                    found = true;
                    start = j + 1;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}