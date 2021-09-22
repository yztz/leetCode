/* https://leetcode-cn.com/problems/implement-rand10-using-rand7/ */
public class Solution { // 并非最优

    public int rand7() {
        return -1;
    }

    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        /*
         *  [1-40] => [1-10]
         *  1, 11, 21, 31 => 1
         *  2, 12, 22, 32 => 2
         *  ...
         *  10, 20, 30, 40 => 10
         */
        return 1 + (idx - 1) % 10;

    }
}
