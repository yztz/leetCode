import java.util.*;

/*https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/  14ms*/
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> ret = new ArrayList<>();
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();
    TreeNode target;
    int k;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.target = target;
        this.k = k;
        dfs(root);
        searchK(target, 0);
        return ret;
    }

    public void searchK(TreeNode root, int depth) {
        if (root == null) return;
        if (set.contains(root)) return;

        set.add(root);

        if (depth == k) {
            ret.add(root.val);
            return;
        }

        searchK(root.left, depth + 1);
        searchK(root.right, depth + 1);
        searchK(parent.getOrDefault(root, null), depth + 1);
    }

    public int dfs(TreeNode root) {
        if (root == null) return -1;

        if (root == target) {
            return 1;
        }
        int lDis = dfs(root.left);
        int rDis = dfs(root.right);
        if(lDis > 0 && lDis <= k) {
            parent.put(root.left, root);
            return 1 + lDis;
        }
        if(rDis > 0 && rDis <= k) {
            parent.put(root.right, root);
            return 1 + rDis;
        }

        return -1;
    }
}
