package com.leatcode.easy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75
 * 392. Is Subsequence
 * 
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abc", t = "ahbgdc" Output: true
 * 
 * Example 2:
 * 
 * Input: s = "axc", t = "ahbgdc" Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 100 0 <= t.length <= 104 s and t consist only of lowercase
 * English letters.
 * 
 * 
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k
 * >= 109, and you want to check one by one to see if t has its subsequence. In
 * this scenario, how would you change your code?
 * 
 */
public class IsSubsequenceTest {
	// 4:05 4:25 - 20 min Beats 100% of all answers
	public boolean isSubsequence(String s, String t) {
		boolean found = false;
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		int f = 0;
		for (int i = 0; i < tChar.length && f < sChar.length; i++) {
			if (sChar[f] == tChar[i]) {
				f++;
			}
			if (f == sChar.length) {
				found = true;
			}
		}
		if (f == sChar.length) {
			found = true;
		}
		return found;

	}

	@Test
	public void case1() {
		assertTrue(isSubsequence("abc", "ahbgdc"));
	}

	@Test
	public void case2() {
		assertFalse(isSubsequence("axc", "ahbgdc"));
	}

	@Test
	public void caseSame() {
		assertTrue(isSubsequence("axc", "axc"));
	}

	@Test
	public void case3() {
		assertTrue(isSubsequence("", "ahbgdc"));
	}

}
