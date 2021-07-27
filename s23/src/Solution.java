import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/  0ms */
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

    int ans = - 1;
    int rootVal;
    public int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode node) {
        if (node == null) return;

        if (ans != -1 && node.val > ans) {
            return;
        }

        if (node.val > rootVal) {
            ans = node.val;
        }

        dfs(node.left);
        dfs(node.right);
    }



}
