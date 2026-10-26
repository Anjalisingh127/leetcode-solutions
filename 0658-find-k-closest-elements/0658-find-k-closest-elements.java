class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        for (int num : arr) {
            list.add(num);
        }

        while (list.size() > k) {
            int first = list.get(0);
            int last = list.get(list.size() - 1);

            if (Math.abs(first - x) > Math.abs(last - x)) {
                list.remove(0);
            } else {
                list.remove(list.size() - 1);
            }
        }

        return list;
    }
}