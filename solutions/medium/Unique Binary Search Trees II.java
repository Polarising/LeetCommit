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
    public List<TreeNode> generateTrees(int n) {
        if (n<1){
            return new ArrayList<TreeNode>();
        }
    	return helper(1,n);
    }
    private List<TreeNode> helper(int p,int q){
    	if(p>q){
    		List<TreeNode> result=new ArrayList<TreeNode>();
    		result.add(null);
    		return result;
    	}
    	List<TreeNode> roots=new ArrayList<TreeNode>();
    	for(int i=p;i<=q;i++){
    		List<TreeNode> left=helper(p,i-1);
    		List<TreeNode> right=helper(i+1,q);
    		for(TreeNode l : left){
    			for(TreeNode r : right){
    				TreeNode root=new TreeNode(i);
    				root.left=l;
    				root.right=r;
    				roots.add(root);
    			}
    		}
    	}
    	return roots;
    }
    
    //Second solution by using DP
    //memo[i][j] will contain a list of root node, which indicates how many unique BST from i to j, so we need a 3D list(array) to store them
}