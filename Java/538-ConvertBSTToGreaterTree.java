/*

https://leetcode.com/problems/convert-bst-to-greater-tree/

538. Convert BST to Greater Tree

Given a Binary Search Tree (BST),convert it to a Greater Tree such that 
every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13


Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

*/


class Solution {
	public int convertBST(TreeNode root,int num) {
		if(root.right != null){
			num = convertBST(root.right,num);
		}
		
		root.val += num;
		
		if(root.left != null){
			return convertBST(root.left,root.val);
		}
		
		return root.val;
	}
	
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
			return null;
		}
		
		convertBST(root,0);
		
		return root;
    }
}
