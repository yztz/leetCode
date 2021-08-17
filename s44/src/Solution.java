
/* https://leetcode-cn.com/problems/student-attendance-record-i/  */
public class Solution {

    public boolean checkRecord(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }

//    public boolean checkRecord(String s) {
//        int absent = 0;
//        int late = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == 'A') {
//                absent++;
//                late = 0;
//                if (absent >= 2) return false;
//            } else if (c == 'L') {
//                late++;
//                if (late >= 3) return false;
//            } else if (c == 'P') {
//                late = 0;
//            }
//        }
//
//        return true;
//    }
}
