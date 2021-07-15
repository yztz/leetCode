import java.util.Arrays;

/* https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/ 5ms */
public class Solution {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int prev = 1;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - prev) > 1) {
                arr[i] = prev + 1;
            }
            prev = arr[i];
        }

        return arr[arr.length - 1];
    }
}
