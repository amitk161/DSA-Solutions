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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diamter = new int[1];
        height(root, diamter);
        return diamter[0];
    }

    private int height(TreeNode node, int[] diamter){
        if(node == null)
            return 0;

        int lh = height(node.left, diamter);
        int rh = height(node.right, diamter);

        diamter[0] = Math.max(diamter[0], lh+rh);

        return 1 + Math.max(lh, rh);    
    }
}