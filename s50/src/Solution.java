/* https://leetcode-cn.com/problems/get-maximum-in-generated-array/  0ms*/
public class Solution {

    public int getMaximumGenerated(int n) {
        int max = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 1) {
                max = Math.max(max, getNum(i));
            }
        }

        return max;
    }

    int getNum(int i) {
        if (i == 0 || i == 1) return i;

        if (i % 2 == 0) return getNum(i / 2);
        else return getNum(i / 2) + getNum(i / 2 + 1);
    }
}
