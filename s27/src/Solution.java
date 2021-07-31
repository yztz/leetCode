
/* https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/  */

import java.util.*;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int maxCol = -1;
    int minCol = Integer.MAX_VALUE;

    Map<Integer, PriorityQueue<TreeNode>> map = new HashMap<>();
    Map<TreeNode, Integer> rows = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            if (map.containsKey(i)) {
                PriorityQueue<TreeNode> queue = map.get(i);
                List<Integer> col = new ArrayList<>();
                TreeNode head = queue.poll();
                while (head != null) {
                    col.add(head.val);
                    head = queue.poll();
                }
                res.add(col);
            }
        }
        return res;
    }

    public void dfs(TreeNode root, int row, int col) {
        if (null == root) return;
        rows.put(root, row);
        map.putIfAbsent(col, new PriorityQueue<>((o1, o2) -> {
            int row1 = rows.get(o1);
            int row2 = rows.get(o2);
            if (row1 > row2) return 1;
            else if (row1 < row2) return -1;
            else return Integer.compare(o1.val, o2.val);
        }));
        map.get(col).add(root);
        maxCol = Math.max(maxCol, col);
        minCol = Math.min(minCol, col);

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}
