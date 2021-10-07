public class Solution {

    public static void main(String[] args) {
        Solution solution  = new Solution();
        System.out.println(solution.countSegments("Hello, my name is John"));
    }

    public int countSegments(String s) {
        int count = 0;
        int pos = 0;
        while (pos < s.length()) {
            if (!Character.isWhitespace(s.charAt(pos))) {
                count++;
                while (pos < s.length() && !Character.isWhitespace(s.charAt(pos))) pos++;
            } else {
                pos++;
            }
        }

        return count;
    }
}
