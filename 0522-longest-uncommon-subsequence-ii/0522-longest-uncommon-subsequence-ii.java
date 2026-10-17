class Solution {
    public int findLUSlength(String[] strs) {
        int max = -1;

        for (int i = 0; i < strs.length; i++) {
            boolean uncommon = true;

            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    uncommon = false;
                    break;
                }
            }

            if (uncommon) {
                max = Math.max(max, strs[i].length());
            }
        }

        return max;
    }

    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == a.length();
    }
}