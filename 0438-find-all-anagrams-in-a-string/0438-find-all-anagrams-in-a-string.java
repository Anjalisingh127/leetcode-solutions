class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();

        char[] target = p.toCharArray();
        Arrays.sort(target);

        for (int i = 0; i <= n - m; i++) {
            
            String sub = s.substring(i, i + m);
            char[] arr = sub.toCharArray();

            Arrays.sort(arr);

            if (Arrays.equals(arr, target)) {
                ans.add(i);
            }
        }

        return ans;
    }
}
