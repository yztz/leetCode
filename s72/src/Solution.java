/* https://leetcode-cn.com/problems/valid-sudoku/  */
public class Solution {


    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] digits = new boolean[10];
            char[] row = board[i];
            // row
            for (char digit : row) {
                if (digit != '.') {
                    int d = digit - '0';
                    if (digits[d]) return false;
                    digits[d] = true;
                }
            }
            // col
            digits = new boolean[10];
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c != '.') {
                    int d = c - '0';
                    if (digits[d]) return false;
                    digits[d] = true;
                }

            }
            int blockRow = i / 3;
            int blockCol = i % 3;
            digits = new boolean[10];
            for (int j = 0; j < 3; j++) {
                int rowIdx = blockRow * 3 + j;
                for (int k = 0; k < 3; k++) {
                    char c = board[rowIdx][blockCol * 3 + k];
                    if (c != '.') {
                        int d = c - '0';
                        if (digits[d]) return false;
                        digits[d] = true;
                    }
                }
            }
        }

        return true;
    }


}
