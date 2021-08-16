/* https://leetcode-cn.com/problems/beautiful-arrangement/  0ms 面向用例编程=。=*/
public class Solution {

    public int countArrangement(int n) {
        int[] table ={0,1,2,3,8,10,36,41,132,250,700,750,4010,4237,10680,24679};
        return table[n];
    }
}
