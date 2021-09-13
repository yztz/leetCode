import java.util.HashMap;
import java.util.Map;

/* https://leetcode-cn.com/problems/number-of-boomerangs/  */
public class Solution {

    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n < 3) return 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] end = points[i];
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                int[] point = points[j];
                int dis = (point[0] - end[0]) * (point[0] - end[0]) + (point[1] - end[1]) * (point[1] - end[1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }

            for (int key : map.keySet()) {
                int num = map.get(key);
                answer += num * (num - 1);
            }
        }

        return answer;
    }
}
