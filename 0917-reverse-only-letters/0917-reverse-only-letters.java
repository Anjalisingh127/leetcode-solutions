class Solution {
    public String reverseOnlyLetters(String s) {
        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                list.add(s.charAt(i));
            }
        }

        Collections.reverse(list);

        StringBuilder result = new StringBuilder();
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                result.append(list.get(j++));
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}