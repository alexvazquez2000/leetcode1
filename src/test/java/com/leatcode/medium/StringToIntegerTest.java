package com.leatcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * 
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

    Whitespace: Ignore any leading whitespace (" ").
    Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
    Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
    Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.

Return the integer as the final result.

 

Example 1:

Input: s = "42"

Output: 42

Explanation:

The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^

Example 2:

Input: s = " -042"

Output: -42

Explanation:

Step 1: "   -042" (leading whitespace is read and ignored)
            ^
Step 2: "   -042" ('-' is read, so the result should be negative)
             ^
Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
               ^

Example 3:

Input: s = "1337c0d3"

Output: 1337

Explanation:

Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
         ^
Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
             ^

Example 4:

Input: s = "0-1"

Output: 0

Explanation:

Step 1: "0-1" (no characters read because there is no leading whitespace)
         ^
Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
          ^

Example 5:

Input: s = "words and 987"

Output: 0

Explanation:

Reading stops at the first non-digit character 'w'.

 

Constraints:

    0 <= s.length <= 200
    s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.


 */

public class StringToIntegerTest {
	
	/** O(N) - beats 100%  memory beats 7.61% */
	public static int myAtoi(String s) {
		s = s.trim();
		boolean isNegative = false;
		int i = 0;
		if (s.isEmpty()) {
			return 0;
		}
		if (s.charAt(0) == '-') {
			isNegative = true;
			i++;
		} else if (s.charAt(0) == '+') {
			//just update the index
			i++;
		}
		//skip leading zeros
		while (i<s.length() && s.charAt(i) == '0') {
			i++;
		}
		long ret = 0;
		boolean valid = true;
		for (; i < s.length() && valid; i++) {
			if (s.charAt(i) >='0' &&  s.charAt(i) <='9' ) {
				
				if (ret < 0) {
					ret = (ret * 10) - (s.charAt(i) -'0');
				} else {
					ret = (ret * 10) + (s.charAt(i) -'0');
				}
				if (isNegative) {
					ret *= -1;
					isNegative = false;
				}

				if (ret > Integer.MAX_VALUE ) {
					ret = Integer.MAX_VALUE;
					valid = false;
				} else if (ret < Integer.MIN_VALUE ) {
					ret = Integer.MIN_VALUE;
					valid = false;
				}
			} else {
				valid = false;
			}
				
		}
		return (int)ret;
	}

	@Test
	void case1() {
		assertEquals(42, myAtoi("42"));
	}

	@Test
	void case2() {
		assertEquals(-42, myAtoi("-042"));
	}

	@Test
	void case3() {
		assertEquals(1337, myAtoi("1337c0d3"));
	}

	@Test
	void case4() {
		assertEquals(1, myAtoi("1-0"));
	}

	@Test
	void case5() {
		assertEquals(0, myAtoi("words and 987"));
	}

	@Test
	void caseOverflow() {
		assertEquals(-2147483648, myAtoi("-91283472332"));
					// -1089159116
	}

	@Test
	void caseBlank() {
		assertEquals(0, myAtoi(""));
	}

	@Test
	void caseJustPlus() {
		assertEquals(0, myAtoi("+"));
	}


}
