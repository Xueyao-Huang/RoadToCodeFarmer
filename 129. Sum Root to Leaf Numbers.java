/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    private int sum(TreeNode node, int preSum) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.val + preSum * 10;
        }
        return sum(node.left, node.val + preSum * 10) + sum(node.right, node.val + preSum * 10);
    }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] cur = new int[1];
        int[] sum = new int[1];
        sumHelper(root, sum, cur);
        return sum[0];
    }
    
    private void sumHelper(TreeNode root, int[] sum, int[] cur) {
        if (root == null) {
            return;
        }
        cur[0] += root.val;
        if (root.left == null && root.right == null) {
            sum[0] += cur[0];
            return;
        }
        cur[0] = cur[0] * 10;
        int temp = cur[0];
        sumHelper(root.left, sum, cur);
        cur[0] = temp;
        sumHelper(root.right, sum, cur);
    }
}
