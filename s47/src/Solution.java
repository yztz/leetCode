
/* https://leetcode-cn.com/problems/reverse-string-ii/submissions/ */
public class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < n) {
            reverse(chars, i, Math.min(i + k, n));
            i += 2 * k;
        }
        return String.valueOf(chars);
    }


    public void reverse(char[] chars, int begin, int end) {
        end = end - 1;
        while (begin < end) {
            char ch = chars[end];
            chars[end] = chars[begin];
            chars[begin] = ch;
            begin++;
            end--;
        }
    }

}
