/*
https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

/*
class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
*/
class Solution {
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
		if(l1 == null){
			return l2;
		}
		
		while(l2 != null){
			
			ListNode currentNodel1 = l1;
			ListNode prevNodel1 = null;
			
			while(currentNodel1.val < l2.val){
				
				prevNodel1 = currentNodel1;
				currentNodel1 = currentNodel1.next;
				
				if( currentNodel1 == null){
					prevNodel1.next = l2;
					return l1;
				}
			}
			
			ListNode currentNodel2 = l2;
			ListNode prevNodel2 = null;
			
			while(currentNodel2.val <= currentNodel1.val){
				
				prevNodel2 = currentNodel2;
				currentNodel2 = currentNodel2.next;
				
				if( currentNodel2 == null){
					break;
				}
			}
			
			ListNode newl2Ref = currentNodel2;
			
			if(prevNodel1 == null){
				l1 = l2;
				prevNodel1 = l1;
				prevNodel2.next = currentNodel1;
			}else{
				prevNodel1.next = l2;
				prevNodel2.next = currentNodel1;
			}
			
			l2 = newl2Ref;
		}
		
		return l1;
    }
}
