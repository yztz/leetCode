/* https://leetcode-cn.com/problems/binary-search/ 二分查找，没啥好说，最重要的是边界条件 */
public class Solution {

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] > target) j = mid - 1;
            else if (nums[mid] < target) i = mid + 1;
            else return mid;
        }

        return -1;
    }
}
