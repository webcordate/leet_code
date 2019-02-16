/*
https://leetcode.com/problems/symmetric-tree/

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
   
Note:
Bonus points if you could solve it both recursively and iteratively.
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
    public boolean check(TreeNode leftSubtree,TreeNode rightSubtree){
		
		if(leftSubtree.val !=  rightSubtree.val){
			return false;
		}
		
		boolean result = true;
		
		if(leftSubtree.left != null && rightSubtree.right != null){
			result = check(leftSubtree.left,rightSubtree.right);
		}else if(leftSubtree.left != null || rightSubtree.right != null){
			return false;
		}
		
		if(result){
			if(leftSubtree.right != null && rightSubtree.left != null){
				result = check(leftSubtree.right,rightSubtree.left);
			}else if(leftSubtree.right != null || rightSubtree.left != null){
				return false;
			}
		}
		
		return result;
	}
	
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null)
			return true;
		
		if(root.left == null && root.right == null){
			return true;
		}else if(root.left == null || root.right == null){
			return false;
		}
		
		return check(root.left,root.right);
    }
}
