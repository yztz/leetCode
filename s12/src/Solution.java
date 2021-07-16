
/* https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/ 0ms*/
public class Solution {
    // c1
//    public int search(int[] nums, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (Integer num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        return map.getOrDefault(target, 0);
//    }
    // c2
//    public int search(int[] nums, int target) {
//        int count = 0;
//        for (int num : nums) {
//            if (num == target) count++;
//        }
//
//        return count;
//    }
    // c3
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int count = 1;
                for (int i = mid - 1; i >= 0 && nums[i] == target; i--) count++;
                for (int i = mid + 1; i < nums.length && nums[i] == target; i++) count++;
                return count;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return 0;
    }


}