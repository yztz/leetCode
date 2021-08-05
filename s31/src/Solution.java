import java.util.Arrays;

/* https://leetcode-cn.com/problems/valid-triangle-number/  250ms */
public class Solution {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                int c = a + b;
                int left = j + 1, right = nums.length - 1, k = j;
                int mid = nums.length;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (nums[mid] < c) {
                        k = mid;
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
                count += k - j;
            }
        }
        return count;
    }
}
