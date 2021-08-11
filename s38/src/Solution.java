import java.util.HashMap;
import java.util.Map;

/* https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/ 183ms */
public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        int ans = 0;
        for (int i = 0; i < n; i++) f[i] = new HashMap<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }
}
