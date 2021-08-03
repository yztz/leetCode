/* https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/  1ms */
public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int left = 0, right = nums.length - 1;

        for (int i = 1; i < nums.length && nums[i] >= nums[i - 1]; i++) left = i;
        for (int i = nums.length - 1; i > 0 && nums[i] >= nums[i - 1]; i--) right = i;
        //System.out.printf("left: %d and right: %d%n", left, right);
        if (left >= right) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left + 1; i < nums.length; i++) min = Math.min(min, nums[i]);
        for (int i = right - 1; i >= 0; i--) max = Math.max(max, nums[i]);
        while (left >= 0 && nums[left] > min) left--;
        while (right < nums.length && nums[right] < max) right++;
        //System.out.printf("left: %d and right: %d%n", left, right);
        return right - left - 1;
    }
}
