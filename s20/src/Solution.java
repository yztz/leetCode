import java.util.HashMap;
import java.util.Map;

/* https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/ 5ms  */
public class Solution {

    //    public String maximumTime(String time) {
//        char h1 = time.charAt(0);
//        char h2 = time.charAt(1);
//        char m1 = time.charAt(3);
//        char m2 = time.charAt(4);
//        String[] slot = {
//                h2 == '?' || h2 < '4' ? "2" : "1",
//                h1 == '?' || h1 == '2' ? "3" : "9",
//                ":",
//                "5",
//                "9"};
//        for (int i = 0; i < 5; i++) if (time.charAt(i) == '?') time = time.replaceFirst("\\?", slot[i]);
//
//        return time;
//    }
    public String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            arr[0] = ('4' <= arr[1] && arr[1] <= '9') ? '1' : '2';
        }
        if (arr[1] == '?') {
            arr[1] = (arr[0] == '2') ? '3' : '9';
        }
        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);

    }

}
