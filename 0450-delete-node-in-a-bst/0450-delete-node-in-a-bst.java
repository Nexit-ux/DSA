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
    public TreeNode Ino(TreeNode root){
        if(root.left == null) return root;
        else return Ino(root.left);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val > key){
            root.left = deleteNode(root.left , key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right , key);
        }
        else{
            //No children
            if(root.left == null && root.right == null){
                return null;
            }

            //Single child
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            //Two children
            if(root.left != null && root.right != null){
                TreeNode ino = Ino(root.right);
                root.val = ino.val;
                root.right = deleteNode(root.right , ino.val);
            }
        }
        return root;
    }
}