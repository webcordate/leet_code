<?php
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

$sol = new Solution();
print_r($sol->twoSum(array(2, 7, 11, 15), 9));
echo '</br>';
print_r($sol->twoSum(array(2, 3, 4, 5, 7, 11, 15), 9));
