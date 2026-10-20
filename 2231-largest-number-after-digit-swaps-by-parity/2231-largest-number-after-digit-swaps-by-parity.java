class Solution {
    public int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i] - '0';
                int b = arr[j] - '0';

                if (a % 2 == b % 2 && a < b) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return Integer.parseInt(new String(arr));
    }
}