import java.util.*;

/*https://leetcode-cn.com/problems/the-skyline-problem/  1ms*/
public class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ret = new ArrayList<>();

        List<int[]> ps = new ArrayList<>();
        for (int[] building : buildings) {
            int height = building[2];
            ps.add(new int[]{building[0], -height});
            ps.add(new int[]{building[1], height});
        }
        ps.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int prev = 0;
        queue.add(prev);

        for (int[] point : ps) {
            if (point[1] < 0) {
                queue.add(-point[1]);
            } else {
                queue.remove(point[1]);
            }

            int cur = queue.peek();
            if (cur != prev) {
                List<Integer> list = new ArrayList<>();
                list.add(point[0]);
                list.add(cur);
                ret.add(list);
                prev = cur;
            }
        }

        return ret;
    }

}
