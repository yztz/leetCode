/* https://leetcode-cn.com/problems/out-of-boundary-paths/ 摘自LeetCode官方，思想同源 */
public class Solution {
    //    int[][][] possible;
//    int m;
//    int n;
//
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        possible = new int[m][n][maxMove + 1];
//        this.m = m;
//        this.n = n;
//        return find(startColumn, startRow, maxMove);
//    }
//
//    public int find(int x, int y, int restMove) {
//        if (x < 0 || x >= n || y < 0 || y >= m) {
//            return 1;
//        }
//        if (restMove == 0) return 0;
//        if (possible[y][x][restMove] != 0) return possible[y][x][restMove];
//
//        int count = 0;
//        count += find(x - 1, y, restMove - 1);
//        count += find(x + 1, y, restMove - 1);
//        count += find(x, y + 1, restMove - 1);
//        count += find(x, y - 1, restMove - 1);
//        count %= (Math.pow(10, 9) + 7);
//        possible[y][x][restMove] = count;
//        return count;
//    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000000007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int outCounts = 0;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++) {
            int[][] dpNew = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int count = dp[j][k];
                    if (count > 0) {
                        for (int[] direction : directions) {
                            int j1 = j + direction[0], k1 = k + direction[1];
                            if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                                dpNew[j1][k1] = (dpNew[j1][k1] + count) % MOD;
                            } else {
                                outCounts = (outCounts + count) % MOD;
                            }
                        }
                    }
                }
            }
            dp = dpNew;
        }
        return outCounts;
    }


}
