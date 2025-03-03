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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        inOrder(ans, root);
        return ans;
    }

    private void inOrder(List<Integer> ans, TreeNode node){
        if(node == null)
            return;

        inOrder(ans, node.left);
        ans.add(node.val);
        inOrder(ans, node.right);    
    }
}