import java.util.*;

/* https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/ 95ms*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] adj = {{2, 1}, {3, 4}, {3, 2}};
        solution.restoreArray(adj);
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        int len = adjacentPairs.length + 1;
        int[] ret = new int[len];

        Map<Integer, List<Integer>> map = new HashMap<>();    // value : idx
        for (int[] pair : adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        // find start
        for (int key : map.keySet()) {
            if (map.get(key).size() == 1) {
                ret[0] = key;
                break;
            }
        }
        ret[1] = map.get(ret[0]).get(0);
        for (int i = 2; i < len; i++) {
            List<Integer> list = map.get(ret[i - 1]);
            ret[i] = list.get(0) == ret[i - 2] ? list.get(1) : list.get(0);
        }

        return ret;
    }
}
