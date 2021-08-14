import java.util.Arrays;
import java.util.Map;

/* https://leetcode-cn.com/problems/count-unhappy-friends/  2ms */
public class Solution {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] relations = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] preference = preferences[i];
            for (int j = 0; j < n - 1; j++) {
                relations[i][preference[j]] = j;
            }
        }

        int[] dogs = new int[n];
        for (int[] pair : pairs) {
            dogs[pair[0]] = pair[1];
            dogs[pair[1]] = pair[0];
        }
        int ans = 0;
        for (int x = 0; x < n; x++) {
            int y = dogs[x];
            int xAndY = relations[x][y];
            for (int i = 0; i < xAndY; i++) {
                int u = preferences[x][i];
                int v = dogs[u];
                if (relations[u][v] > relations[u][x]) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }

}



