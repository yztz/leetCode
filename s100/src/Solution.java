/* https://leetcode-cn.com/problems/count-and-say/ */
public class Solution {
    public String countAndSay(int n) {
        String base = "1";

        for (int i = 1; i < n; i++) {
            System.out.println(base);
            base = parse(base);
        }
        return base;
    }

    public String parse(String base) {
        int n = base.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            char c = base.charAt(i);
            char nc = base.charAt(i + 1);
            if (c != nc) {
                sb.append(count).append(c);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count).append(base.charAt(n - 1));

        return sb.toString();
    }

}
