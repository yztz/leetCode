import java.util.HashMap;
import java.util.Map;

/* https://leetcode-cn.com/problems/path-sum-iii/  */
public class Solution { // 一维前缀和？？

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixes = new HashMap<>();
        prefixes.put(0, 1);
        return dfs(root, prefixes, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Integer, Integer> prefixes, int curr,int target) {
        if (root == null) return 0;
        curr += root.val;

        int ret = prefixes.getOrDefault(curr - target, 0);
        prefixes.put(curr, prefixes.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefixes, curr, target);
        ret += dfs(root.right, prefixes, curr, target);
        prefixes.put(curr, prefixes.getOrDefault(curr, 1) - 1);
        return ret;
    }
}

class TreeNode {
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
