class Solution {
    public int minSetSize(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] bucket = new int[arr.length + 1];

        for (int freq : map.values()) {
            bucket[freq]++;
        }

        int removed = 0;
        int count = 0;

        for (int i = arr.length; i >= 1; i--) {

            while (bucket[i] > 0) {

                removed += i;
                count++;

                if (removed >= arr.length / 2) {
                    return count;
                }

                bucket[i]--;
            }
        }

        return count;
    }
}
