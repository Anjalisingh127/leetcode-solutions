
class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ("aeiouAEIOU".indexOf(ch) != -1) {
                vowels.add(ch);
            }
        }

        Collections.reverse(vowels);

        StringBuilder result = new StringBuilder();
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ("aeiouAEIOU".indexOf(ch) != -1) {
                result.append(vowels.get(j++));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
