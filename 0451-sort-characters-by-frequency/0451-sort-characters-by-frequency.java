class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Store unique characters
        List<Character> list = new ArrayList<>(map.keySet());

        // Sort by frequency in descending order
        Collections.sort(list, (a, b) ->
            map.get(b) - map.get(a)
        );

        // Build the result
        StringBuilder result = new StringBuilder();

        for (char c : list) {
            for (int i = 0; i < map.get(c); i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
