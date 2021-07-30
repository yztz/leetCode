public class Solution {

    public int titleToNumber(String columnTitle) {
        int ret = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            ret = ret * 26 + c - 'A' + 1;
        }
        return ret;
    }
}
