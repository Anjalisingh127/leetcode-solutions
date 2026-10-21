class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;

        for (int k = 0; k < n; k++) {
            int max = 0;

            for (int i = 0; i < m; i++) {
                int rowMax = 0;
                int idx = -1;

                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > rowMax) {
                        rowMax = grid[i][j];
                        idx = j;
                    }
                }

                if (idx != -1) {
                    grid[i][idx] = 0;
                }

                max = Math.max(max, rowMax);
            }

            sum += max;
        }

        return sum;
    }
}