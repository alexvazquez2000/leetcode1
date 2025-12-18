package com.leatcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MergeStringsAlternativeTest {
	/**
	 * https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
	 * 
	 * 1768. Merge Strings Alternately
	 * 
	 * You are given two strings word1 and word2. Merge the strings by adding
	 * letters in alternating order, starting with word1. If a string is longer than
	 * the other, append the additional letters onto the end of the merged string.
	 * 
	 * Return the merged string.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: word1 = "abc", word2 = "pqr" Output: "apbqcr" Explanation: The merged
	 * string will be merged as so: word1: a b c word2: p q r merged: a p b q c r
	 * 
	 * Example 2:
	 * 
	 * Input: word1 = "ab", word2 = "pqrs" Output: "apbqrs" Explanation: Notice that
	 * as word2 is longer, "rs" is appended to the end. word1: a b word2: p q r s
	 * merged: a p b q r s
	 * 
	 * Example 3:
	 * 
	 * Input: word1 = "abcd", word2 = "pq" Output: "apbqcd" Explanation: Notice that
	 * as word1 is longer, "cd" is appended to the end. word1: a b c d word2: p q
	 * merged: a p b q c d
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static String mergeStringAlternative(String word1, String word2) {
		StringBuilder response = new StringBuilder(word1.length() + word2.length());
		int x = 0;
		do {
			response.append(word1.charAt(x));
			response.append(word2.charAt(x));
			x++;
		} while (x < word1.length() && x < word2.length());
		if (x < word1.length()) {
			response.append(word1.substring(x));
		} else if (x < word2.length()) {
			response.append(word2.substring(x));
		}
		return response.toString();
	}

	@Test
	void mergeStringAlternativeTest() {
		assertEquals("apbqcr", mergeStringAlternative("abc", "pqr"));
		assertEquals("apbqrs", mergeStringAlternative("ab", "pqrs"));
		assertEquals("apbqcd", mergeStringAlternative("abcd", "pq"));
	}

}
