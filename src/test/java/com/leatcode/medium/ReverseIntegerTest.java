package com.leatcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * https://leetcode.com/problems/reverse-integer/
 * 
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21

 

Constraints:

    -231 <= x <= 231 - 1


 */
public class ReverseIntegerTest {

	/** beats 5.43% memory beats 6.34% 
	 * could do it with mod 10, and push into an array*/
	public static int reverse(int x) {
		String s = "" + x;
		StringBuilder b = new StringBuilder();
		for ( int i= s.length() -1; i >= 0; i--) {
			b.append(s.charAt(i));
		}
		int r = 0;
		try {
			if (x < 0) {
				r = -1 * Integer.valueOf(b.toString().substring(0, s.length()-1));
			} else {
				r = Integer.parseInt(b.toString());
			}
		} catch (NumberFormatException e) {
			return 0;
		}
		return r;
	}
	
	@Test
	void case1() {
		assertEquals(321, reverse(123));
	}

	@Test
	void case2() {
		assertEquals(-321, reverse(-123));
	}

	@Test
	void case3() {
		assertEquals(21, reverse(120));
	}
	
	@Test
	void case4() {
		assertEquals(0, reverse(1534236469));
	}


}
