import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/ 6ms */
public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int infinite = Integer.MAX_VALUE / 2;
        int[][] f = new int[k + 2][n];

        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(f[i], infinite);
        }
        f[0][src] = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                f[i][to] = Math.min(f[i][to], f[i - 1][from] + cost);
            }
        }
        int ans = infinite;
        for (int i = 1; i <= k + 1; i++) ans = Math.min(ans, f[i][dst]);

        return ans == infinite ? -1 : ans;
    }
}
