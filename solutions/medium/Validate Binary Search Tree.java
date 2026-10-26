/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // public boolean isValidBST(TreeNode root) {
    //     if(root==null){
    //     	return true;
    //     }
    //     Stack<Integer> stack=new Stack<Integer>();
    //     inorder(root,stack);//for inorder, each previous node is less than current node
    //     int temp=stack.pop();
    //     while(!stack.empty()){
    //     	int checked=stack.pop();
    //     	if(temp>=checked){
    //     		return false;
    //     	}else{
    //     		temp=checked;
    //     	}
    //     }
    //     return true;
    // }
    // private void inorder(TreeNode node,Stack<Integer> stack){
    // 	if(node.right!=null){
    // 		inorder(node.right,stack);
    // 	}
    // 	stack.push(node.val);
    // 	if(node.left!=null){
    // 		inorder(node.left,stack);
    // 	}
    // }

    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long min, long max){
        if(node == null) {
            return true;
        }

        if(node.val<=min || node.val>=max){
            return false;
        }

        return helper(node.left,min,node.val) && helper(node.right,node.val,max);
    }
}