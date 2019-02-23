/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
		
        if(root == null){
			return 0;
		}
		
		int leftSubtreeDepth = 0;
		int rightSubtreeDepth = 0;
		
		if(root.left != null){
			leftSubtreeDepth = maxDepth(root.left);
		}
		
		if(root.right != null){
			rightSubtreeDepth = maxDepth(root.right);
		}
		
		if(leftSubtreeDepth > rightSubtreeDepth)
			return ++leftSubtreeDepth;
		else
			return ++rightSubtreeDepth;
    }
}
