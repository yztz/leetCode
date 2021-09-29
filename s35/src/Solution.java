
/* https://leetcode-cn.com/problems/n-th-tribonacci-number/  2ms*/
public class Solution {

    public int tribonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;

        return 2 * tribonacci(n - 1) - tribonacci(n - 4);
    }
}
