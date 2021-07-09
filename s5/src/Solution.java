import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3,3,3};
        System.out.println(solution.majorityElement(nums));
    }
    // Boyer-Moore 摩尔投票算法 1ms
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        if (count == 0) return -1;
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }

        return count > nums.length / 2 ? candidate : -1;
    }
//    myself 12ms
//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        int halfLen = nums.length / 2;
//        if (nums.length % 2 == 1) {
//            for (int key : map.keySet()) {
//                if (map.get(key) > halfLen) return key;
//            }
//        } else  {
//            Iterator<Integer> iter = map.keySet().iterator();
//            while (iter.hasNext()) {
//                int key = iter.next();
//                if (map.get(key) == halfLen) {
//                    if (iter.hasNext()) return map.get(iter.next()) < halfLen ? key : -1;
//                    return key;
//                } else if (map.get(key) > halfLen) {
//                    return key;
//                }
//            }
//        }
//
//        return -1;
//    }
}
