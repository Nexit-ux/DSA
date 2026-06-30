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
    public int getIdx(int val , int[] inorder , int left , int right){
        for(int i=left ; i<= right ; i++){
            if(inorder[i] == val) return i;
        }
        return -1;
    }
    public TreeNode build(int[] preorder , int[] inorder , int left , int right){
        if(left > right) return null;
        TreeNode node = new TreeNode(preorder[preIdx]);
        int inrIdx = getIdx(preorder[preIdx] , inorder , left , right);
        preIdx++;
        node.left = build(preorder , inorder , left , inrIdx-1);
        node.right = build(preorder , inorder , inrIdx+1 , right);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder , inorder , 0 , preorder.length-1);
    }
}