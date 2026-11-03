class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prevGroup = 0;
        int currGroup = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;
            } else {
                count += Math.min(prevGroup, currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }
        
        return count + Math.min(prevGroup, currGroup);
    }
}