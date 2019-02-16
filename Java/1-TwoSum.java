/*
     
https://leetcode.com/problems/two-sum/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> helperMap = new HashMap<Integer, Integer>();

        if(nums.length < 2)
            return null;

        for (int i = 0; i< nums.length; i++){

            int diffToTarget = target - nums[i];

            if(helperMap.containsKey(nums[i]))
                return new int[]{helperMap.get(nums[i]), i};
            else
                helperMap.put(diffToTarget, i);
        }

        return new int[]{0, 0};
        
    }
}
