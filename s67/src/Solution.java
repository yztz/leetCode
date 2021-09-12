
/* https://leetcode-cn.com/problems/valid-parenthesis-string/  */
public class Solution { // ☆☆☆

    public boolean checkValidString(String s) {
        int len = s.length();
        int max = 0, min = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                max++;
                min++;
            } else if (c == ')') {
                max--;
                min = Math.max(min - 1, 0);
                if (max < 0) return false;
            } else {
                min = Math.max(min - 1, 0);
                max++;
            }
        }

        return min == 0;
    }
}
