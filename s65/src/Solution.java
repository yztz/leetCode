/* https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/ 2ms */
public class Solution {

    public int chalkReplacer(int[] chalk, int k) {
        long  count = 0;
        for (int num : chalk) count += num;
        k %= count;
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] <= k) {
                k -= chalk[i];
            } else {
                return i;
            }
        }
        return 0;
    }
}
