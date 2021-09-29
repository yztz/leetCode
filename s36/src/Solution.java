import java.util.ArrayList;
import java.util.List;

/* https://leetcode-cn.com/problems/arithmetic-slices/ 0ms */
public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        List<Integer> lens = new ArrayList<>();
        int length = 2;
        int currDelta = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            int delta = nums[i] - nums[i - 1];
            if (delta == currDelta) {
                length++;
            } else {
                currDelta = delta;
                if (length > 2) lens.add(length);
                length = 2;
            }
        }
        if (length > 2) lens.add(length);
        System.out.println(lens);
        int count = 0;
        for (int len : lens) {
            count += count(len);
        }
        return count;
    }

    public int count(int len) {
        int count = 0;
        for (int i = 3; i <= len; i++) {
            count += len - i + 1;
        }
        return count;
    }
}
