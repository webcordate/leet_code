package com.webcordate.leetcode.answers;

import org.junit.Assert;
import org.junit.Test;

public class TestTwoSum {

    @Test
    public void testRandomTestCases() {

        int[] testCase1 = new int[]{1, 2};
        int target1  = 3;

        int[] ans1 = TwoSum.twoSum(testCase1, target1);
        int[] expected1 = new int[]{0, 1};

        Assert.assertEquals(expected1[0], ans1[0]);
        Assert.assertEquals(expected1[1], ans1[1]);

        int[] testCase2 = new int[]{3, 3};
        int target2  = 6;

        int[] ans2 = TwoSum.twoSum(testCase2, target2);
        int[] expected2 = new int[]{0, 1};

        Assert.assertEquals(expected2[0], ans2[0]);
        Assert.assertEquals(expected2[1], ans2[1]);



        int[] testCase3 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int target3  = 5;

        int[] ans3 = TwoSum.twoSum(testCase3, target3);
        int[] expected3 = new int[]{1, 2};

        Assert.assertEquals(expected3[0], ans3[0]);
        Assert.assertEquals(expected3[1], ans3[1]);

    }
}
