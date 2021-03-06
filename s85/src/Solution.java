/* https://leetcode-cn.com/problems/super-washing-machines/submissions/ */
public class Solution {

    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int count = 0;
        for (int num : machines) count += num;
        if (count % n != 0) return -1;

        int avg = count / n;
        int answer = 0, sum = 0;
        for (int machine : machines) {
            // 当前洗衣机中需要转移的数量
            int diff = machine - avg;
            // 0 - i 洗衣机中需要转移的数量
            sum += diff;
            answer = Math.max(answer, Math.max(Math.abs(sum), diff));

        }

        return answer;
    }
}
