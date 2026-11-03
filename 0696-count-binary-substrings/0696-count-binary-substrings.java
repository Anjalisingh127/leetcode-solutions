class Solution {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int prev = 0;
        int curr = 1;
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                curr++;
            } else {
                count += (prev < curr) ? prev : curr;
                prev = curr;
                curr = 1;
            }
        }
        
        return count + ((prev < curr) ? prev : curr);
    }
}