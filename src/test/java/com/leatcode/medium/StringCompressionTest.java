package com.leatcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 * https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
 * 443. String Compression
 * 
 * Given an array of characters chars, compress it using the following
 * algorithm:
 * 
 * Begin with an empty string s. For each group of consecutive repeating
 * characters in chars:
 * 
 * If the group's length is 1, append the character to s. Otherwise, append the
 * character followed by the group's length.
 * 
 * The compressed string s should not be returned separately, but instead, be
 * stored in the input character array chars. Note that group lengths that are
 * 10 or longer will be split into multiple characters in chars.
 * 
 * After you are done modifying the input array, return the new length of the
 * array.
 * 
 * You must write an algorithm that uses only constant extra space.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: chars = ["a","a","b","b","c","c","c"] Output: Return 6, and the first
 * 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to
 * "a2b2c3".
 * 
 * Example 2:
 * 
 * Input: chars = ["a"] Output: Return 1, and the first character of the input
 * array should be: ["a"] Explanation: The only group is "a", which remains
 * uncompressed since it's a single character.
 * 
 * Example 3:
 * 
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"] Output:
 * Return 4, and the first 4 characters of the input array should be:
 * ["a","b","1","2"]. Explanation: The groups are "a" and "bbbbbbbbbbbb". This
 * compresses to "ab12".
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= chars.length <= 2000 chars[i] is a lowercase English letter, uppercase
 * English letter, digit, or symbol.
 * 
 * 
 * 
 * 
 * @since 2025-04-02
 */
public class StringCompressionTest {

	// OK on first pass - 24.50% better than other solutions - 50 min
	// TODO: pass int by reference - I used an array
	// I tried inlining the function processPrevious() but that made no difference
	public static int compress_OK(char[] chars) {
		char last = '\0';
		int count = 0;
		int totalCount = 0;
		int[] index = new int[1];
		index[0] = 0;
		for (int x = 0; x < chars.length; x++) {
			if (chars[x] == last) {
				count++;
			} else {
				if (last != '\0') {
					char[] digits = (count + "").toCharArray();
					totalCount += processPrevious(last, count, digits, chars, index);
				}
				last = chars[x];
				count = 1;
			}
		}
		char[] digits = (count + "").toCharArray();
		totalCount += processPrevious(last, count, digits, chars, index);
		return totalCount;
	}

	private static int processPrevious(char last, int count, char[] digits, char[] chars, int[] index) {
		int printCount = 1;
		chars[index[0]++] = last;
		if (count > 1) {
			for (char ch : digits) {
				printCount++;
				chars[index[0]++] = ch;
			}
		}
		return printCount;
	}

	public static int compress(char[] chars) {
		char last = '\0';
		int count = 0;
		int totalCount = 0;
		int index = 0;
		for (int x = 0; x < chars.length; x++) {
			if (chars[x] == last) {
				count++;
			} else {
				if (last != '\0') {
					char[] digits = (count + "").toCharArray();
					chars[index++] = last;
					totalCount++;
					if (count > 1) {
						for (char ch : digits) {
							totalCount++;
							chars[index++] = ch;
						}
					}
				}
				last = chars[x];
				count = 1;
			}
		}
		char[] digits = (count + "").toCharArray();
		chars[index++] = last;
		totalCount++;
		if (count > 1) {
			for (char ch : digits) {
				totalCount++;
				chars[index++] = ch;
			}
		}
		return totalCount;
	}

	@Test
	public void case1() {
		char[] chars = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		assertEquals(6, compress(chars));
	}

	@Test
	public void case2() {
		char[] chars = new char[] { 'a' };
		assertEquals(1, compress(chars));
	}

	@Test
	public void case3() {
		char[] chars = new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
		assertEquals(4, compress(chars));
	}

}
