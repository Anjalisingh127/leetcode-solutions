
class Solution {
    public String makeGood(String s) {

        StringBuilder str = new StringBuilder(s);

        boolean changed = true;

        while (changed) {
            changed = false;

            for (int i = 0; i < str.length() - 1; i++) {

                char a = str.charAt(i);
                char b = str.charAt(i + 1);

                if (Math.abs(a - b) == 32) {
                    str.delete(i, i + 2);
                    changed = true;
                    break;
                }
            }
        }

        return str.toString();
    }
}
