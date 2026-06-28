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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    level.add(cur.val);
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }

            if (!level.isEmpty()) {
                res.add(level);
            }
        }

        return res;
    }
}
