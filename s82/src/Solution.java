/* https://leetcode-cn.com/problems/sum-of-two-integers/ */
public class Solution {


    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }


}