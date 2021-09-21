/* https://leetcode-cn.com/problems/length-of-last-word/ */
public class Solution {

    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length - 1].length();
    }
}
