class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] ans = new int[k];

        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);

        for (int i = start; i <= end; i++) {

            int[] a = getMax(nums1, i);
            int[] b = getMax(nums2, k - i);

            int[] merged = merge(a, b);

            if (compare(merged, 0, ans, 0) > 0) {
                ans = merged;
            }
        }

        return ans;
    }

    private int[] getMax(int[] nums, int k) {

        int[] stack = new int[k];

        int top = 0;
        int drop = nums.length - k;

        for (int num : nums) {

            while (top > 0 && drop > 0 &&
                   stack[top - 1] < num) {
                top--;
                drop--;
            }

            if (top < k) {
                stack[top++] = num;
            } else {
                drop--;
            }
        }

        return stack;
    }
    
    private int[] merge(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        int i = 0, j = 0, p = 0;

        while (i < a.length || j < b.length) {

            if (compare(a, i, b, j) > 0) {
                result[p++] = a[i++];
            } else {
                result[p++] = b[j++];
            }
        }

        return result;
    }

    private int compare(int[] a, int i, int[] b, int j) {

        while (i < a.length && j < b.length) {

            if (a[i] != b[j]) {
                return a[i] - b[j];
            }

            i++;
            j++;
        }

        return (a.length - i) - (b.length - j);
    }
}