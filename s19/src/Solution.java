/* https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/  0ms */
public class Solution {

    public boolean isCovered(int[][] ranges, int left, int right) {
        System.out.println(left + ";" + right);
        for (int[] range : ranges) {
            int l = range[0];
            int r = range[1];
            if (left > r || right < l) continue;
            if (left >= l) {
                if (right <= r) return true;
                else {
                    return isCovered(ranges, r + 1, right);
                }
            } else {
                return isCovered(ranges, left, l - 1);
            }
        }
        return false;
    }
}
