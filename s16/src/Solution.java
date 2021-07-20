import java.util.Arrays;

/* https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/  57ms */
public class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = -1;
        for (int i = 0; i < len / 2; i++) {
            max = Math.max(max, nums[i] + nums[len - i - 1]);
        }
        return max;
    }
}
