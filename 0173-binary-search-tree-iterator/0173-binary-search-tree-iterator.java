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
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public void helper(TreeNode root , Stack<TreeNode> stk){
        if(root == null) return;
        stk.push(root);
        helper(root.left , stk);
    }
    public BSTIterator(TreeNode root) {
        helper(root , st);
    }
    
    public int next() {
        TreeNode ans = st.pop();
        if(ans.right != null){
            helper(ans.right , st);
        }
        return ans.val;
    }
    
    public boolean hasNext() {
        return st.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */