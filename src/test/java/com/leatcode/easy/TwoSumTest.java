package com.leatcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.leatcode.util.Helper;

/**
 * https://leetcode.com/problems/two-sum/description/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 

Constraints:

    2 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9
    -10^9 <= target <= 10^9
    Only one valid answer exists.

 */
class TwoSumTest {

	/**
	 * This run in O(N^2) -  it beats 28.74% and memory beats 20.19%
	 * This was one of the first problems I worked on, about May 2025, but for some reason it wasn't recorded.
	 * (Re-)Submitted on Dec 18, 2025
	 */
	public static int[] twoSum(int[] nums, int target) {
		int[] response = new int[2];
		boolean done = false;
		for (int x = 0; x < nums.length - 1 && !done; x++) {
			for (int y = x + 1; y < nums.length && !done; y++) {
				if (nums[x] + nums[y] == target) {
					response[0] = x;
					response[1] = y;
					done = true;
				}
			}
		}
		return response;
	}

	@Test
	void sum1() {
		assertTrue(Helper.testArrayResponse(twoSum(new int[] { 2, 7, 11, 15 }, 9), new int[] { 0, 1 }));
		assertTrue(Helper.testArrayResponse(twoSum(new int[] { 3, 2, 4 }, 6), new int[] { 1, 2 }));
		assertTrue(Helper.testArrayResponse(twoSum(new int[] { 3, 3 }, 6), new int[] { 0, 1 }));
	}

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

	/**
	 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
	 * 1071. Greatest Common Divisor of Strings
	 * 
	 * For two strings s and t, we say "t divides s" if and only if s = t + t + t +
	 * ... + t + t (i.e., t is concatenated with itself one or more times).
	 * 
	 * Given two strings str1 and str2, return the largest string x such that x
	 * divides both str1 and str2.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: str1 = "ABCABC", str2 = "ABC" Output: "ABC"
	 * 
	 * Example 2:
	 * 
	 * Input: str1 = "ABABAB", str2 = "ABAB" Output: "AB"
	 * 
	 * Example 3:
	 * 
	 * Input: str1 = "LEET", str2 = "CODE" Output: ""
	 * 
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= str1.length, str2.length <= 1000 str1 and str2 consist of English
	 * uppercase letters.
	 * 
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String gcdOfStrings(String str1, String str2) {
		List<String> gdcOfString1 = gcdList(str1, str2);
		List<String> gdcOfString2 = gcdList(str2, str1);

		String response = "";
		boolean done = false;
		for (int x = 0; x < gdcOfString1.size() && !done; x++) {
			if (gdcOfString2.contains(gdcOfString1.get(x))) {
				done = true;
				response = gdcOfString1.get(x);
			}
		}

		return response;
	}

	private static List<String> gcdList(String str1, String str2) {
		List<String> response = new ArrayList<>();
		int len = str2.length();
		while (len >= 1) {
			StringBuilder testString = new StringBuilder();
			while (testString.length() < str1.length()) {
				testString.append(str2.substring(0, len));
			}
			if (str1.equals(testString.toString())) {
				response.add(str2.substring(0, len));
			}
			len--;
		}

		System.out.println("-----------");
		for (String x : response) {
			System.out.println(x);
		}
		return response;
	}

	@Test
	void gcdOfStringsTest() {
		assertEquals("ABC", gcdOfStrings("ABCABC", "ABC"));
		assertEquals("AB", gcdOfStrings("ABABAB", "ABAB"));
		assertEquals("ABAB", gcdOfStrings("ABABABAB", "ABAB"));
		assertEquals("", gcdOfStrings("LEET", "CODE"));
	}

}
