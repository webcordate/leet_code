/*

https://leetcode.com/problems/median-of-two-sorted-arrays/

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/

object Solution {
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        
        val numsSMALLER = if (nums1.size <= nums2.size) nums1 else nums2
        val numsLARGER = if (nums1.size > nums2.size) nums1 else nums2
        
        var left = 0
        var right = numsSMALLER.size
        val numsSMALLERSize = numsSMALLER.size 
        val numsLARGERSize = numsLARGER.size
        
        while(left <= right){
            
            //(Int) Making sure, mid is always a whole number (as it needs to be used for indexing)
            var midNumsSMALLER: Int = (left + right)/2
            var midNumsLARGER: Int = (numsLARGER.size + numsSMALLER.size + 1)/2 - midNumsSMALLER
        
            val maxLNumsSMALLER = midNumsSMALLER match {
                case 0 => Int.MinValue
                case _ => numsSMALLER(midNumsSMALLER -1)
            }
            
            val minRNumsSMALLER = midNumsSMALLER match {
                case `numsSMALLERSize` => Int.MaxValue
                case _ => numsSMALLER(midNumsSMALLER)
            }
        
            val maxLNumsLARGER = midNumsLARGER match {
                case 0 => Int.MinValue
                case _ => numsLARGER(midNumsLARGER-1)
            }

            val minRNumsLARGER = midNumsLARGER match {
                case `numsLARGERSize` => Int.MaxValue
                case _ => numsLARGER(midNumsLARGER)
            }
            
            if(maxLNumsSMALLER <= minRNumsLARGER && maxLNumsLARGER <= minRNumsSMALLER){
                ((numsSMALLERSize + numsLARGERSize) % 2) match {
                    case 0 =>   return ((Math.max(maxLNumsSMALLER,maxLNumsLARGER) + Math.min(minRNumsSMALLER, minRNumsLARGER)).toDouble)/2
                    case _ => return Math.max(maxLNumsSMALLER, maxLNumsLARGER)
                }
            }else if (maxLNumsSMALLER > minRNumsLARGER){
                right = midNumsSMALLER - 1
            }else{
                left = midNumsSMALLER + 1
            }
        }
    0.0 //Weird but to match scala function definition of return type
    }
}
