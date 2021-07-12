/* https://leetcode-cn.com/problems/h-index-ii/ 0ms 45.5MB*/
public class Solution {

    public int hIndex(int[] citations) {
        int len = citations.length;
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (citations[i] <= count) {
                return count;
            }
            count++;
        }
        return count;
    }
}
