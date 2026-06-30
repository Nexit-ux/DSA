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
    public int maxLevelSum(TreeNode root) {
        int maxlev = 1;
        int maxsum = root.val;
        int lev = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int sum = 0;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(sum > maxsum){
                    maxsum = sum;
                    maxlev = lev;
                }
                if(q.isEmpty()){
                    break;
                }
                else{
                    sum = 0;
                    q.add(null);
                    lev++;
                }
            }
            else{
                sum += curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return maxlev;
    }
}