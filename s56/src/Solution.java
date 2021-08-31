import java.util.Arrays;

/* https://leetcode-cn.com/problems/corporate-flight-bookings/ 2ms */
public class Solution {
    // 最初始解法
//    public int[] corpFlightBookings(int[][] bookings, int n) {
//        int[] answer = new int[n];
//        for (int[] booking : bookings) {
//            int last = booking[1];
//            int num = booking[2];
//            for (int i = booking[0]; i <= last; i++) {
//                answer[i - 1] += num;
//            }
//        }
//
//        return answer;
//    }

    // 差分数组
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n + 1];
        for (int[] booking : bookings) {
            int num = booking[2];
            answer[booking[0] - 1] += num;
            answer[booking[1]] -= num;
        }
        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }

        return Arrays.copyOf(answer, n);
    }
}
