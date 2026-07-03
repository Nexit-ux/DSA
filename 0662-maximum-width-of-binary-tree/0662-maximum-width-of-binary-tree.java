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
    class pair{
        TreeNode node;
        int idx;
        public pair(TreeNode node , int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Deque<pair> q = new ArrayDeque<>();
        q.add(new pair(root , 0));
        while(!q.isEmpty()){
            int size = q.size();
            pair left = q.peekFirst();
            pair right = q.peekLast();
            max = Math.max(max , right.idx - left.idx + 1);
            for(int i=0 ; i<size ; i++){
                pair curr = q.remove();
                if(curr.node.left != null){
                    q.add(new pair(curr.node.left , (2*curr.idx)+1));
                }
                if(curr.node.right != null){
                    q.add(new pair(curr.node.right , (2*curr.idx)+2));
                }
            }
        }
        return max;
    }
}