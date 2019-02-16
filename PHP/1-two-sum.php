/*******************************
URL : https://leetcode.com/problems/two-sum/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
********************************/

class Solution {
    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $result = [];
        $minusresult = [];

        for($i = 0; $i < count($nums); $i++) {
          $minus = $target - $nums[$i];

          if (isset($minusresult[$nums[$i]])) {
              $result[$minusresult[$nums[$i]]] = 0;
              $result[$i] = 0;
          }

          $minusresult[$minus] = $i;

        }
        
        return array_keys($result);
    }
}

/***********************
- For testing purpose only.
************************
$sol = new Solution();
print_r($sol->twoSum(array(2, 7, 11, 15), 9));
echo '</br>';
print_r($sol->twoSum(array(2, 3, 4, 5, 7, 11, 15), 9));
************************/
