import java.util.Arrays;

/* https://leetcode-cn.com/problems/super-ugly-number/ 43ms */
public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] nums = new int[n];
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 0);
        nums[0] = 1;
        for (int i = 1; i < n;) {
            int primeIdx = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
//                int numIdx = pointers[j];
//                if (numIdx >= n) continue;
                int next = nums[pointers[j]] * primes[j];
                if (next < min) {
                    min = next;
                    primeIdx = j;
                }
            }
            if (nums[i - 1] != min) {
                nums[i] = min;
                i++;
            }
            pointers[primeIdx]++;
        }
        System.out.println(Arrays.toString(nums));
        return nums[n - 1];
    }
}
