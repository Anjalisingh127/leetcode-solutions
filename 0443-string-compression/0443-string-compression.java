class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        int index = 0;
        int i = 0;

        while (i < n) {

            char ch = chars[i];
            int count = 0;

            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }

            chars[index++] = ch;

            if (count > 1) {

                int start = index;

                while (count > 0) {
                    chars[index++] = (char) ('0' + count % 10);
                    count /= 10;
                }

                int end = index - 1;

                while (start < end) {
                    char temp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = temp;

                    start++;
                    end--;
                }
            }
        }

        return index;
    }
}