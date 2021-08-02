import java.util.*;

/* https://leetcode-cn.com/problems/network-delay-time/ djstl  882ms */
public class Solution {

    Map<Integer, List<Pair>> routes = new HashMap<>();
    Map<Integer, Integer> costs = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            routes.putIfAbsent(time[0], new ArrayList<>());
            routes.get(time[0]).add(new Pair(time[1], time[2]));
        }
        dfs(k, 0);

        if (costs.keySet().size() != n) return -1;

        int time = 0;
        for (int cost : costs.values()) time = Math.max(time, cost);
        return time;
    }

    public void dfs(int u, int time) {
        costs.put(u, time);

        for (Pair pair : routes.getOrDefault(u, new ArrayList<>())) {
            int cost = time + pair.time;
            if (!costs.containsKey(pair.target) || costs.get(pair.target) > cost) {
                dfs(pair.target, cost);
            }
        }
    }

    static class Pair {
        int target;
        int time;

        Pair(int target, int time) {
            this.target = target;
            this.time = time;
        }
    }
}
