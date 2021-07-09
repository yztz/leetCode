import java.util.HashMap;
import java.util.Map;

/*
https://leetcode-cn.com/problems/binary-subarrays-with-sum/ 43.4ms 22ms
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums = new int[]{0,0,0,0,1};
        int goal = 1;
        System.out.println(solution.numSubarraysWithSum(nums, goal));
    }
    //第一次提交
//    public int numSubarraysWithSum(int[] nums, int goal) {
//        if (goal == 0) {
//            int count = 0, tmp = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] == 0) {
//                    tmp++;
//                } else {
//                    count += (tmp + 1) * tmp / 2;
//                    tmp = 0;
//                }
//            }
//            count += (tmp + 1) * tmp / 2;
//            return count;
//        }
////        System.out.println(Arrays.toString(nums));
//
//        int [] dp = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 1) {
//                int tmp = 0;
//                for (int j = i; j < nums.length; j++) {
//                    tmp += nums[j];
//                    if (tmp == goal) {
//                        dp[j] = i + 1;
//                        break;
//                    }
//                }
//            }
//        }
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (dp[i] == 0) continue;
//
//            int pre_idx = dp[i] - 1;
////            System.out.println("pre_idx: " + pre_idx + " end_idx: " + i);
//            int beginNum = 0, endNum = 0;
//            for (int j = pre_idx - 1; j >= 0 && nums[j] == 0; j--) beginNum ++;
//            for (int j = i + 1; j < nums.length && nums[j] == 0; j++) endNum ++;
//
//            count += (beginNum + 1) * (endNum + 1);
//        }
//
//        return count;
//    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ret = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += map.getOrDefault(sum - goal, 0);
        }
        return ret;
    }
}
