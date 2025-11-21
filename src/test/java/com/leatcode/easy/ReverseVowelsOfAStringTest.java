package com.leatcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * Given a string s, reverse only all the vowels in the string and return it.
 * 
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
 * and upper cases, more than once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "IceCreAm"
 * 
 * Output: "AceCreIm"
 * 
 * Explanation:
 * 
 * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes
 * "AceCreIm".
 * 
 * Example 2:
 * 
 * Input: s = "leetcode"
 * 
 * Output: "leotcede"
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 3 * 105 s consist of printable ASCII characters.
 * 
 * 
 * 
 */
class ReverseVowelsOfAStringTest {

	@Test
	void test() {
		assertEquals("AceCreIm", reverseVowels("IceCreAm"));
		assertEquals("leotcede", reverseVowels("leetcode"));
	}

	private String reverseVowels(String string) {
		Stack<Character> stack = new Stack<>();
		char[] buffer = string.toCharArray();
		Pattern p = Pattern.compile("[aeiouAEIOU]");
		for (int x = 0; x < buffer.length; x++) {
			Matcher m = p.matcher(buffer[x] + "");
			if (m.find()) {
				stack.push(buffer[x]);
				buffer[x] = '\n';
			}
		}
		StringBuilder response = new StringBuilder();
		for (int x = 0; x < buffer.length; x++) {
			if (buffer[x] == '\n') {
				response.append(stack.pop());
			} else {
				response.append(buffer[x]);
			}
		}
		return response.toString();
	}

}
