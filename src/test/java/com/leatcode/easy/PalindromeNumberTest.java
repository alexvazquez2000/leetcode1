package com.leatcode.easy;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

/**
 * May 27, 2025
 * 
 * https://leetcode.com/problems/palindrome-number/ Given an integer x, return
 * true if x is a, and false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: x = 121 Output: true Explanation: 121 reads as 121 from left to right
 * and from right to left.
 * 
 * Example 2:
 * 
 * Input: x = -121 Output: false Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 * 
 * Input: x = 10 Output: false Explanation: Reads 01 from right to left.
 * Therefore it is not a palindrome.
 * 
 * 
 * 
 * Constraints:
 * 
 * -231 <= x <= 231 - 1
 * 
 * Follow up: Could you solve it without converting the integer to a string?
 * 
 */
public class PalindromeNumberTest {

	// beats 16.14% Memory beats 96.11%
	public boolean isPalindrome(int x) {
		boolean isPalindrome = true;
		String value = x + "";
		int left = 0;
		int right = value.length() - 1;
		while (isPalindrome == true && left <= right) {
			if (value.charAt(left) != value.charAt(right)) {
				isPalindrome = false;
			}
			left++;
			right--;
		}
		return isPalindrome;
	}

	@Test
	void case1() {
		assertTrue(isPalindrome(121));
	}

	@Test
	void case2() {
		assertFalse(isPalindrome(-121));
	}

	@Test
	void case3() {
		assertFalse(isPalindrome(10));
	}

}
