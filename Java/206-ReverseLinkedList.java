/*

https://leetcode.com/problems/reverse-linked-list/

206. Reverse Linked List

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution{
	
	private ListNode reverseList(ListNode prevNode,ListNode currentNode){
		if(currentNode == null){
			return prevNode;
		}
		
		ListNode nextNode = currentNode.next;
		currentNode.next = prevNode;
		
		return reverseList(currentNode,nextNode);
	} 
	 
    public ListNode reverseList(ListNode head) {
			return reverseList(null,head);
    }
}
