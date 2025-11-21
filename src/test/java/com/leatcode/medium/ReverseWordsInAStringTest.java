package com.leatcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * 151. Reverse Words in a String
 * 
 * Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the
 * words. Do not include any extra spaces.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "the sky is blue" Output: "blue is sky the"
 * 
 * Example 2:
 * 
 * Input: s = " hello world " Output: "world hello" Explanation: Your reversed
 * string should not contain leading or trailing spaces.
 * 
 * Example 3:
 * 
 * Input: s = "a good example" Output: "example good a" Explanation: You need to
 * reduce multiple spaces between two words to a single space in the reversed
 * string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104 s contains English letters (upper-case and lower-case),
 * digits, and spaces ' '. There is at least one word in s.
 * 
 * 
 * 
 * Follow-up: If the string data type is mutable in your language, can you solve
 * it in-place with O(1) extra space?
 * 
 * 
 */
public class ReverseWordsInAStringTest {
	// My solution beats 59.24%
	public String reverseWords(String s) {
		String[] words = s.split("\\s+");
		StringBuilder buffer = new StringBuilder(s.length());
		for (int i = words.length - 1; i >= 0; i--) {
			String word = words[i].trim();
			if (!word.isBlank()) {
				buffer.append(words[i]).append(" ");
			}
		}
		return buffer.toString().trim();
	}

	// their solution only beats 40.42%
	public String reverseWords_b(String s) {
		// remove leading spaces
		s = s.trim();
		// split by multiple spaces
		List<String> wordList = Arrays.asList(s.split("\\s+"));
		Collections.reverse(wordList);
		return String.join(" ", wordList);
	}

	@Test
	public void case1() {
		assertEquals("blue is sky the", reverseWords("the sky is blue"));
	}

	@Test
	public void case2() {
		assertEquals("world hello", reverseWords("  hello world  "));
	}

	@Test
	public void case3() {
		assertEquals("example good a", reverseWords("a good   example"));
	}

	@Test
	public void case2b() {
		assertEquals("ss world hello", reverseWords("  hello world  ss  "));
	}

}
