class Solution {
    public boolean judgeSquareSum(int c) {

        for (long a = 0; a * a <= c; a++) {

            long bSquare = c - a * a;
            long b = (long) Math.sqrt(bSquare);

            if (b * b == bSquare) {
                return true;
            }
        }

        return false;
    }
}