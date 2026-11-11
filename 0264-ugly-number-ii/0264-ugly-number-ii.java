
import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();

        set.add(1L);

        long num = 1;

        for (int i = 0; i < n; i++) {
            num = set.pollFirst();

            set.add(num * 2);
            set.add(num * 3);
            set.add(num * 5);
        }

        return (int) num;
    }
}
