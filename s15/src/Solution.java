import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/ 158ms */
public class Solution {

    public int maxFrequency(int[] nums, int k) {
        int maxFreq = -1;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int target = nums[i];
            int rest = k;
            int count = 1;
            int step = 0;
            for (int j = i - 1; j >= 0; j--) {
                int current = nums[j];
                if (target == current) {
                    count += 1;
                    step += 1;
                } else {
                    int delta = target - current;
                    if (delta > rest) break;

                    rest -= delta;
                    count += 1;
                }
            }
            if (count > maxFreq) maxFreq = count;
            i -= step;
        }
        return maxFreq;
    }
}
