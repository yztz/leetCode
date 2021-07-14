import java.util.Arrays;

/*https://leetcode-cn.com/problems/minimum-absolute-sum-difference/ 63ms */
public class Solution {
    public static void main(String[] args) {
        int[] num1 = {5,2,7};
        int[] num2 = {10,7,12};
        Solution solution = new Solution();
        System.out.println(solution.minAbsoluteSumDiff(num1, num2));
    }


    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int len = nums1.length;

        int[] nums3 = new int[len];
//        int maxIdx = 0;
        for (int i = 0; i < len; i++) {
            nums3[i] = Math.abs(nums1[i] - nums2[i]);
//            if (nums3[i] > nums3[maxIdx]) maxIdx = i;
        }


        Arrays.sort(nums1);
        int idx = -1, val = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int tmp = nums2[i];
            // 边界检查
            if (nums1[len - 1] - tmp <= 0) {
                int delta = nums1[len - 1] - tmp;
                int optimization = nums3[i] + delta;
                if (optimization > 0 && optimization > val) {
                    val = optimization;
                    idx = i;
                }
                continue;
            }
            if (nums1[0] - tmp >= 0) {
                int delta = nums1[0] - tmp;
                int optimization = nums3[i] - delta;
                if (optimization > 0 && optimization > val) {
                    val = optimization;
                    idx = i;
                }
                continue;
            }
            int left = 0, right = len - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int delta1 = nums1[mid] - tmp;
                int delta2 = nums1[mid + 1] - tmp;
                if (delta1 > 0) {
                    right = mid;
                } else if (delta2 < 0) {
                    left = mid;
                } else {
                    System.out.println("i = " + i + " delta1 = " + delta1 + " delta2 = " + delta2);
                    int delta = Math.min(-delta1, delta2);
                    int optimization = nums3[i] - delta;
//                    System.out.println("opt = " + optimization);
                    if (optimization > 0 && optimization > val) {
                        val = optimization;
                        idx = i;
                    }
                    break;
                }
            }

        }
//        System.out.println("idx = " + idx + " opt = " + val);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (i == idx)
                ans += nums3[i] - val;
            else
                ans += nums3[i];
            ans %= (int) (Math.pow(10, 9) + 7);
        }


        return ans;
    }
}
