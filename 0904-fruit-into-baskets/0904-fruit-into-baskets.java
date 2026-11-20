class Solution {
    public int totalFruit(int[] fruits) {

        int left = 0;
        int maxLen = 0;

        int lastFruit = -1;
        int secondLastFruit = -1;

        int lastFruitCount = 0;

        for (int right = 0; right < fruits.length; right++) {

            int curr = fruits[right];

            if (curr != lastFruit && curr != secondLastFruit) {
                left = right - lastFruitCount;
            }

            if (curr == lastFruit) {
                lastFruitCount++;
            } else {
                lastFruitCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = curr;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
