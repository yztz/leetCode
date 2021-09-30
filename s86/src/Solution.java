/* https://leetcode-cn.com/problems/rectangle-area/  */
public class Solution {


    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        if (by2 <= ay1 || by1 >= ay2 || bx1 >= ax2 || bx2 <= ax1) return area1 + area2;

        int width = Math.min(bx2, ax2) - Math.max(bx1, ax1);
        int height =Math.min(ay2, by2) - Math.max(ay1, by1);
        return area1 + area2 - width * height;
    }
}
