/*
https://leetcode.com/problems/valid-parentheses/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
*/

//import java.util.Stack;

class Solution {
	
	private boolean isOpening(char ch){
		switch(ch){
			case '(':
			case '{':
			case '[': 
				return true;
			default: 
				return false;
		}
	}
	
	private	boolean isClosing(char ch){
		switch(ch){
			case ')':
			case '}':
			case ']': 
				return true;
			default: 
				return false;
		}
	}
	
	private int checkPrecedence(char ch){
		switch(ch){
			case '(':
			case ')':
				return 1;
			case '{':
			case '}':
				return 2;
			case '[': 
			case ']':
				return 3;
			default: 
				return 0;
		}
	}
	
    public boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < s.length(); i++){
			
			char ch = s.charAt(i);
			
			if(isOpening(ch)){
				stack.push(ch);
			}else if(isClosing(ch)){
				
				if(stack.empty()){
					return false;
				}
				
				if(checkPrecedence(stack.peek()) == checkPrecedence(ch)){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		if(stack.empty()){
			return true;
		}else{
			return false;
		}
    }
}
