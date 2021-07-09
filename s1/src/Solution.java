/*
https://leetcode-cn.com/problems/delete-columns-to-make-sorted/ 7ms 38.7MB
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String [] strs = new String[]{"rrjk","furt","guzm"};
        System.out.println(solution.minDeletionSize(strs));
    }

    public int minDeletionSize(String[] strs) {
        int strLen = strs[0].length();
        int ret = 0;

        char [] last = new char[strLen];

        for (String tmp : strs) {   //遍历字符串数组
            for (int i = 0; i < strLen; i++) {  //遍历字符串

                if (last[i] != '-') { // 还未排除
                    char c = tmp.charAt(i);
                    if (last[i] <= c) {
                        last[i] = c;
                    } else {
                        last[i] = '-';
                        ret++;
                    }
                }
            }
        }
        return ret;
    }
}
