/* https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/ */
public class Solution {


    public int maxSubArray(int[] nums) {

        int num = 0;
        int max = -100;
        for (int i = 0; i < nums.length; i++) {
            if (num < 0) {
                num = 0;
            }
            num += nums[i];
            if (num > max) {
                max = num;
            }
        }

        return max;
    }
}
