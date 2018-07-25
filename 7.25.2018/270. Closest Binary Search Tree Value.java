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
    public int closestValue(TreeNode root, double target) {
        if (root.val == target) {
            return root.val;
        }
        double diff = Math.abs(root.val - target);
        if (target < root.val && root.left != null) {
            int left = closestValue(root.left, target);
            return diff > Math.abs(target - left) ? left : root.val;
        }
        if (target > root.val && root.right != null) {
            int right = closestValue(root.right, target);
            return diff > Math.abs(target - right) ? right : root.val;
        }
        return root.val;
    }
}
