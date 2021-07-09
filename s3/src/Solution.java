import java.util.Arrays;
/*
https://leetcode-cn.com/problems/longest-valid-parentheses/ 3ms
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()()(())";
        System.out.println(solution.longestValidParentheses(s));

    }

    public int longestValidParentheses(String s) {
        int len = s.length();
        int max = 0;

        if (len == 0) return 0;

        int[] validLen = new int[len];

        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                int pre = i - validLen[i - 1] - 1;
                if (pre >= 0 && s.charAt(pre) == '(') {
                    validLen[i] = validLen[i - 1] + 2;
                    if (pre > 0) validLen[i] += validLen[pre - 1];
                    max = Math.max(max, validLen[i]);
                }
            }
        }

        return max;
    }
}
