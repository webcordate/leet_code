'''
https://leetcode.com/problems/container-with-most-water/

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
'''

class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        low, high = height[0], height[len(height)-1]
        
        container_area = []
        low_index = 0
        high_index = len(height)-1
        
        #print, low_index, high_index
        
        while low_index < high_index:
            #print "append"
            
            container_area.append(min(low,high)*(high_index-low_index))
            #print container_area
            
            if low < high:
                low_index += 1
                low = height[low_index]
            else:
                high_index -=1
                high = height[high_index]
        
        return max(container_area)
