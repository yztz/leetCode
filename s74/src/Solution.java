/* https://leetcode-cn.com/problems/2-keys-keyboard/  */
public class Solution { // 质数？
    // copy + paste = double

    // A time
    // 1 0
    // 2 cp
    // 3 cpp
    // 4 cpcp
    // 5 cpppp
    // 6 cpcpp
    // 7 cpppppp
    // 8 cpcpcp
    // 15 cppppcpp
    public int minSteps(int n) {
        if (n == 1) return 0;
        int factor = findFactor(n);
        if (factor != -1)
            return minSteps(factor) + n / factor;
        else
            return n;
    }

    public int findFactor(int n) {
        for (int i = n - 1; i > 0; i--) {
            if (n % i == 0) return i;
        }

        return -1;
    }
}
