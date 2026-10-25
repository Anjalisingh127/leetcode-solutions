class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new List[s.length() + 1];

        for (char c : map.keySet()) {
            int freq = map.get(c);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(c);
        }

        StringBuilder result = new StringBuilder();

        for (int freq = s.length(); freq >= 1; freq--) {
            if (bucket[freq] != null) {
                for (char c : bucket[freq]) {
                    for (int i = 0; i < freq; i++) {
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }
}
