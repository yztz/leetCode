/* https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/ 0ms */
public class Solution {

    public int balancedStringSplit(String s) {
        int weight = 0;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') weight--;
            else weight++;
            if (weight == 0) answer++;
        }

        return answer;


    }
}
