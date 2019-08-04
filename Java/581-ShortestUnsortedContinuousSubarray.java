/*

https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

581. Shortest Unsorted Continuous Subarray

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.

*/

class Solution {
    
	public int findUnsortedSubarray(int[] nums) {
        
		int aL = nums.length;
		
		if(aL < 2){
			return 0;
		}
		
		// for unsorted-continuous-subarray
		int startIndex = 0;
		int endIndex = aL - 1;
		
		// mix and max values in unsorted-continuous-subarray
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		
		for(int i = 0; i < aL - 1; i++){
			
			if(nums[i] > nums[i+1]){
				
				startIndex = i;
				
				// for endIndex
				
				for(int j = aL-1; j >= startIndex; j--){
					if(nums[j - 1] > nums[j]){
						endIndex = j;
						break;
					}
				}
				
				break;
				
			}else if(i == aL - 2){
				return 0; // Sorted Array
			}
		
		}
		
		// finding min and max values in unsorted-continuous-subarray
		
		for(int i = startIndex; i <= endIndex; i++){
			if(min > nums[i]){
				min = nums[i];
			}
			
			if(max < nums[i]){
				max = nums[i];
			}
			
		}
		
		// finding startIndex and endIndex for unsorted-continuous-subarray
		
		while(startIndex > 0){
			if(nums[startIndex - 1] < min){
				break;
			}else{
				startIndex--;
			}
		}
		
		while(endIndex < aL - 1){
			if(nums[endIndex + 1] > max){
				break;
			}else{
				endIndex++;
			}
		}
						
		return endIndex - startIndex + 1;
    }
}
