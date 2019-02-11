package com.webcordate.leetcode.answers;

/*
*
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
*
* You may assume that each input would have exactly one solution, and you may not use the same element twice.
*
*
* https://leetcode.com/problems/two-sum/
*
* */

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

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
