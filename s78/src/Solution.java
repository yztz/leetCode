/* https://leetcode-cn.com/problems/power-of-three/  */
public class Solution {

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
