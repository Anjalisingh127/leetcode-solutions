import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", 0, 0, n, result);
        return result;
    }

    private void generate(String current, int open, int close,
                          int n, List<String> result) {
        if (open == n && close == n) {
            if (isValid(current)) {
                result.add(current);
            }
            return;
        }

        if (open < n) {
            generate(current + "(", open + 1, close, n, result);
        }

        if (close < n) {
            generate(current + ")", open, close + 1, n, result);
        }
    }

    private boolean isValid(String s) {
        int balance = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}