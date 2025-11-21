package com.leatcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 * May 29, 2025 55 minutes
 * https://leetcode.com/problems/zigzag-conversion/submissions/1648503307/ he
 * string "PAYPALISHIRING" is written in a zigzag pattern on a given number of
 * rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3 Output: "PAHNAPLSIIGYIR"
 * 
 * Example 2:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4 Output: "PINALSIGYAHRPI"
 * Explanation: P I N A L S I G Y A H R P I
 * 
 * Example 3:
 * 
 * Input: s = "A", numRows = 1 Output: "A"
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 s consists of English letters (lower-case and
 * upper-case), ',' and '.'. 1 <= numRows <= 1000
 * 
 * 
 */
public class ZigzagConversionTest {

	// beat 60.91% and memory beats 97.20%
	public String convert(String s, int numRows) {
		StringBuffer[] buffers = new StringBuffer[numRows];
		for (int x = 0; x < numRows; x++) {
			buffers[x] = new StringBuffer();
		}
		int row = 0;
		boolean goingDown = true;
		int i = 0;
		while (i < s.length()) {
			buffers[row].append(s.charAt(i));
			if (goingDown && row < numRows - 1) {
				row++;
			} else if (goingDown && row > 0) {
				row--;
				goingDown = false;
			} else if (!goingDown && row == 0) {
				row++;
				goingDown = true;
			} else if (!goingDown && row > 0) {
				row--;
			}
			i++;
		}
		for (int x = 1; x < numRows; x++) {
			buffers[0].append(buffers[x]);
		}
		return buffers[0].toString();
	}

	@Test
	public void case1() {
		assertEquals(
//				  "P   A   H   N"   0 4 8 2
//				+ "A P L S I I G"   1357913
//				+ "Y   I   R",      2 6 0
				"PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
	}

	@Test
	public void case2() {
		assertEquals(
//				  "P  I  N"  0  6  2
//				+ "A LS IG"  1 57 13
//				+ "YA HR  "  24 80 
//				+ "P  I",    3  9
				"PINALSIGYAHRPI", convert("PAYPALISHIRING", 4));
	}

	@Test
	public void case3() {
		assertEquals("A", convert("A", 1));
	}

	@Test
	public void case3a() {
		assertEquals("ABCD", convert("ABCD", 1));
	}

}
