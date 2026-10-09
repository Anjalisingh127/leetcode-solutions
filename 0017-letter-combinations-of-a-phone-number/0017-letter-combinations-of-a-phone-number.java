import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        result.add("");

        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();

            String letters = map[digit - '0'];

            for (String str : result) {
                for (char ch : letters.toCharArray()) {
                    temp.add(str + ch);
                }
            }

            result = temp;
        }

        return result;
    }
}
