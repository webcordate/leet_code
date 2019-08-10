// import java.util.LinkedList; 
// import java.util.Queue;

/*

https://leetcode.com/problems/invert-binary-tree/

226. Invert Binary Tree

Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.

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
 
/*
class Solution {
	
    public TreeNode invertTree(TreeNode root) {
		
		if(root == null)
			return null;
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
    }
}
*/ 


class Solution {
	
    public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return null;
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(queue.size() > 0){
			
			TreeNode node = queue.remove();
			
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
		
			if(node.left != null)
				queue.add(node.left);
			
			if(node.right != null)
				queue.add(node.right);
		}
		
		return root;
    }
}
