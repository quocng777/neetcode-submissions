/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    private boolean containsSubTree;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (containsSubTree) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (
            root.val == subRoot.val && checkSameTree(root, subRoot)
            || isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot)
            ) {
            containsSubTree = true;
        }

        return containsSubTree;
    }

    private boolean checkSameTree(TreeNode parent, TreeNode sub) {
        if (sub == null && parent == null) {
            return true;
        }

        if (sub == null || parent == null) {
            return false;
        }

        return (
            parent.val == sub.val 
            && checkSameTree(parent.left, sub.left)
            && checkSameTree(parent.right, sub.right)
        );
    }
}
