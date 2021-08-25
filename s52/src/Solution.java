import java.util.*;

/* https://leetcode-cn.com/problems/all-paths-from-source-to-target/  */
public class Solution {

    List<List<Integer>> paths = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        deque.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return paths;
    }


    public void dfs(int[][] graph, int root, int target) {
        if (root == target) {
            paths.add(new ArrayList<>(deque));
            return;
        }

        int[] successors = graph[root];
        for (int next : successors) {
            deque.offerLast(next);
            dfs(graph, next, target);
            deque.pollLast();
        }
    }
}
