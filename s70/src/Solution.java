/* https://leetcode-cn.com/problems/find-peak-element/  */
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean ok = true;
            if (i > 0) {
                if (nums[i - 1] > nums[i]) ok = false;
            }
            if (i < n - 1) {
                if (nums[i + 1] > nums[i]) ok = false;
            }
            if (ok) return i;
        }
        return -1;
    }
}
