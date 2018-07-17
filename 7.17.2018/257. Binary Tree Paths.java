/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // StringBuilder is mutable
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<>();
        addPath(root, list, new StringBuilder());
        return list;
    }
    private void addPath(TreeNode root, List<String> list, StringBuilder sb) {
        sb.append(root.val + "");
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        }
        if (root.left != null) {
            StringBuilder sbl = new StringBuilder(sb);
            addPath(root.left, list, sbl.append("->"));
        }
        if (root.right != null) {
            StringBuilder sbr = new StringBuilder(sb);
            addPath(root.right, list, sbr.append("->"));
        }
    }
}

// String is immutable
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<>();
        addPath(root, list, "");
        return list;
    }
    private void addPath(TreeNode root, List<String> list, String s) {
        if (root.left == null && root.right == null) {
            list.add(s + root.val);
        }
        if (root.left != null) {
            addPath(root.left, list, s + root.val + "->");
        }
        if (root.right != null) {
            addPath(root.right, list, s + root.val + "->");
        }
    }
}
