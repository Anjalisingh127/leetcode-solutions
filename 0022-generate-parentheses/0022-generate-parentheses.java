import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", 0, n, result);
        return result;
    }

    private void generate(String current, int length, int n, List<String> result) {
        if (length == 2 * n) {
            if (isValid(current)) {
                result.add(current);
            }
            return;
        }

        generate(current + "(", length + 1, n, result);
        generate(current + ")", length + 1, n, result);
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