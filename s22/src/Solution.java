import java.util.*;

/* https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/ 0ms  */
public class Solution {

    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }

        List<Integer> d = new ArrayList<>();
        for (int val : arr) {
            if (map.containsKey(val)) {
                int idx = map.get(val);
                int it = binarySearch(d, idx);
                if (it != d.size()) {
                    d.set(it, idx);
                } else {
                    d.add(idx);
                }
            }
        }
        return target.length - d.size();
    }

    public int binarySearch(List<Integer> d, int target) {
        int size = d.size();
        if (size == 0 || d.get(size - 1) < target) {
            return size;
        }
        int low = 0, high = size - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (d.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
