
/* https://leetcode-cn.com/problems/number-of-digit-one/ 0ms */
public class Solution {


    public int countDigitOne(int n) {
        long k = 1;
        int ans = 0;
        while (k <= n) {
            ans += (n / (k * 10)) * k + Math.min(Math.max(n % (k * 10) - k + 1, 0), k);
            k *= 10;
        }
        return ans;
    }
}
