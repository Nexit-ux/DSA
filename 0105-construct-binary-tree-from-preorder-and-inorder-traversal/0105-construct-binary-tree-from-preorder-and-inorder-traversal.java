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
    int preIdx = 0;
    public int getIdx(int[] inorder , int val){
        for(int i=0 ; i<inorder.length ; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
    public TreeNode Build(int[] preorder , int[] inorder , int i , int j){
        if(i > j) return null;
        TreeNode node = new TreeNode(preorder[preIdx]);
        int inrIdx = getIdx(inorder , preorder[preIdx++]);
        node.left = Build(preorder , inorder , i , inrIdx-1);
        node.right = Build(preorder , inorder , inrIdx+1 , j);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return Build(preorder , inorder , 0 , preorder.length-1);
    }
}