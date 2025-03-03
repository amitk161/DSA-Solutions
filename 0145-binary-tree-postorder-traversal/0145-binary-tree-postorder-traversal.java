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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(ans, root);
        return ans;
    }

    private void postOrder(List<Integer> ans, TreeNode node){
        if(node == null)
            return;

        postOrder(ans, node.left);
        postOrder(ans, node.right);
        ans.add(node.val);    
    }
}