/*

https://leetcode.com/problems/diameter-of-binary-tree/

543. Diameter of Binary Tree

Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
 
 */
 
 class Solution {
	
	public int diameterOfTree = 0;
	
	public int setDiameter(TreeNode root) {
		 
		int leftSubtreeDepth = 0;
		int rightSubtreeDepth = 0;
		
		if(root.left != null){
			leftSubtreeDepth = setDiameter(root.left);
		}
		
		if(root.right != null){
			rightSubtreeDepth = setDiameter(root.right);
		}
		
		diameterOfTree = Math.max( diameterOfTree, (leftSubtreeDepth + rightSubtreeDepth) );
		
		// maxDepth
		return Math.max( ++leftSubtreeDepth, ++rightSubtreeDepth );
		
    }
	
    public int diameterOfBinaryTree(TreeNode root) {
		
		if(root != null){
			setDiameter(root);
		}
		
		return diameterOfTree;
		
    }
}
