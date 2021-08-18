/* https://leetcode-cn.com/problems/student-attendance-record-ii/  374ms 286ms*/
public class Solution {
    public int checkRecord(int n) {
        int mod = 1000000007;
        // i:day j:A k:L
        int[][] dp = new int[2][3];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int[][] dpNew = new int[2][3];
            // present
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dpNew[j][0] = (dpNew[j][0] + dp[j][k]) % mod;
                }
            }
            // absent
            for (int k = 0; k < 3; k++) {
                dpNew[1][0] = (dpNew[1][0] + dp[0][k]) % mod;
            }
            // late
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    dpNew[j][k] = (dpNew[j][k] + dp[j][k - 1]) % mod;
                }
            }
            dp = dpNew;
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[j][k]) % mod;
            }
        }
        return sum;
    }

}
