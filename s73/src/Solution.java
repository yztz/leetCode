/* https://leetcode-cn.com/problems/nim-game/  */
public class Solution {
    // 1 2 3 (4) 5 6 7 (8) 9 10
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
