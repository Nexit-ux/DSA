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
    static TreeNode LinkedList(TreeNode root){
        if(root == null) return null;
        TreeNode left = LinkedList(root.left);
        TreeNode right = LinkedList(root.right);
        TreeNode temp = root.right;
        root.right = null;
        if(left != null){
            root.left = null;
            root.right = left;
        }
        TreeNode curr = root;
        while(curr.right != null){
            curr = curr.right;
        }
        curr.right = temp;
        return root;
    }
    public void flatten(TreeNode root) {
        LinkedList(root);
    }
}