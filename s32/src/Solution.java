import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/* https://leetcode-cn.com/problems/find-eventual-safe-states/ 16ms */
public class Solution {

    Map<Integer, Boolean> nodes = new HashMap<>();
    int[][] graph;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        this.graph = graph;
        for (int i = 0; i < graph.length; i++) {
            boolean isSafe = isSafe(i);
            nodes.putIfAbsent(i, isSafe);
            if (isSafe) list.add(i);
        }

        return list;
    }

    public boolean isSafe(int node) {
        if (nodes.containsKey(node)) {
            Boolean isSafe = nodes.get(node);
            if (null == isSafe) {
                nodes.put(node, false);
                return false;
            } else {
                return isSafe;
            }
        }


        int[] edges = graph[node];
        if (edges.length == 0) {
            nodes.put(node, true);
            return true;
        }
        nodes.put(node, null);
        for (int edge : edges) {

            if (!isSafe(edge)) {
                nodes.put(edge, false);
                return false;
            }
        }

        nodes.put(node, true);
        return true;
    }
}
