class Solution {
    public int minSetSize(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int[] freq = new int[map.size()];
        int index = 0;

        for (int value : map.values()) {
            freq[index++] = value;
        }

        Arrays.sort(freq);

        int removed = 0;
        int count = 0;

        for (int i = freq.length - 1; i >= 0; i--) {

            removed += freq[i];
            count++;

            if (removed >= arr.length / 2) {
                break;
            }
        }

        return count;
    }
}
