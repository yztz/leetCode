import java.util.Arrays;

/* https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/  */
public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int answer = 0;
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                answer = count[i];
            } else if (dp[i] == maxLength){
                answer += count[i];
            }
        }

        return answer;
    }
}
