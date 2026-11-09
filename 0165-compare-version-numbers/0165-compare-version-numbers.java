class Solution {
    public int compareVersion(String version1, String version2) {

        int i = 0, j = 0;
        int n = version1.length(), m = version2.length();

        while (i < n || j < m) {

            int start1 = i;
            int start2 = j;

            while (i < n && version1.charAt(i) != '.') {
                i++;
            }

            while (j < m && version2.charAt(j) != '.') {
                j++;
            }

            // Skip leading zeros
            while (start1 < i && version1.charAt(start1) == '0') {
                start1++;
            }

            while (start2 < j && version2.charAt(start2) == '0') {
                start2++;
            }

            int len1 = i - start1;
            int len2 = j - start2;

            // Compare lengths
            if (len1 > len2) return 1;
            if (len1 < len2) return -1;

            // Compare digits
            for (int k = 0; k < len1; k++) {
                char c1 = version1.charAt(start1 + k);
                char c2 = version2.charAt(start2 + k);

                if (c1 > c2) return 1;
                if (c1 < c2) return -1;
            }

            i++;
            j++;
        }

        return 0;
    }
}