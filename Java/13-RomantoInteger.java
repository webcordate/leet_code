/*

https://leetcode.com/problems/roman-to-integer/

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/

class Solution {
    public int romanToInt(String s) {
        
        int index = 0;
        int answer = 0;
        int totalLength = s.length();
        
        HashMap<String, Integer> preDefinedValues = new HashMap<String, Integer>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
    }};
        
        while(index < totalLength){
            
            //System.out.println(s.charAt(index));
            
            if (index < totalLength -1){
                String value = "" + s.charAt(index) + s.charAt(index+1);
                
                if(preDefinedValues.containsKey(value)){
                        answer += preDefinedValues.get(value);
                        index += 2;
                }else{
                    String singleValue = "" + s.charAt(index);
                    answer += preDefinedValues.get(singleValue);
                        index++;
                }
                
            }
            
            if(index == totalLength-1){
                String singleValue = "" + s.charAt(index);
                answer += preDefinedValues.get(singleValue);
                index++;
            }
        }
        
        return answer;
    }
}

