/* https://leetcode-cn.com/problems/divide-two-integers/ */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().divide(-2147483648, 2));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;

        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return -dividend;
        }

        boolean flag = false;
        if (dividend > 0) {
            dividend = -dividend;
            flag = !flag;
        }
        if (divisor > 0) {
            divisor = -divisor;
            flag = !flag;
        }

        int answer = div(dividend, divisor);

        if (flag) {
            if(answer == Integer.MIN_VALUE)
                answer = Integer.MAX_VALUE;
            else
                answer = - answer;
        }

        return answer;
    }

    public int div(int dividend, int divisor) {
        if (dividend > divisor) return 0;
        int step = divisor;
        int answer = 1;
        while (dividend - step <= step) {
            step += step;
            answer += answer;
        }

        return answer + div(dividend - step, divisor);
    }
}
