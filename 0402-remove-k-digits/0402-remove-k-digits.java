
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder res = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (k > 0 && res.length() > 0 &&
                   res.charAt(res.length() - 1) > c) {
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            res.append(c);
        }

        while (k > 0) {
            res.deleteCharAt(res.length() - 1);
            k--;
        }

        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }

        String ans = res.substring(i);
        return ans.isEmpty() ? "0" : ans;
    }
}
