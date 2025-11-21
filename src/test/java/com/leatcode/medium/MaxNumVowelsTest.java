package com.leatcode.medium;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
 * 1456. Maximum Number of Vowels in a Substring of Given Length Given a string
 * s and an integer k, return the maximum number of vowel letters in any
 * substring of s with length k.
 * 
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abciiidef", k = 3 Output: 3 Explanation: The substring "iii"
 * contains 3 vowel letters.
 * 
 * Example 2:
 * 
 * Input: s = "aeiou", k = 2 Output: 2 Explanation: Any substring of length 2
 * contains 2 vowels.
 * 
 * Example 3:
 * 
 * Input: s = "leetcode", k = 3 Output: 2 Explanation: "lee", "eet" and "ode"
 * contain 2 vowels.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s consists of lowercase English letters. 1 <= k <=
 * s.length
 * 
 * 
 * March 7, 2025 - 30 minutes
 */
public class MaxNumVowelsTest {
	// bets 36.56% runtime, 24.31% memory
	public static int maxVowels(String s, int k) {
		HashMap<Character, Integer> vowels = new HashMap<>();
		vowels.put('a', 0);
		vowels.put('e', 0);
		vowels.put('i', 0);
		vowels.put('o', 0);
		vowels.put('u', 0);

		int count = 0;
		for (int i = 0; i < k; i++) {
			if (vowels.containsKey(s.charAt(i))) {
				count++;
			}
		}
		int max = count;
		System.out.println(0 + " " + s.charAt(0) + " count=" + count + " max=" + max);
		for (int i = k; i < s.length(); i++) {
			if (count == k) {
				return k;
			}
			if (vowels.containsKey(s.charAt(i - k))) {
				if (vowels.containsKey(s.charAt(i))) {
					// do nothing, both are vowels
				} else if (count > 0) {
					count--;
				}
			} else {
				if (vowels.containsKey(s.charAt(i))) {
					count++;
				}
			}
			max = Math.max(max, count);
			System.out.println(i + " " + s.charAt(i) + " count=" + count + " max=" + max);
		}
		return max;
	}

	// their answer with sliding window - same algorithm as above, but cleaner and
	// faster
	public static int maxVowels2(String s, int k) {
		Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

		// Build the window of size k, count the number of vowels it contains.
		int count = 0;
		for (int i = 0; i < k; i++) {
			count += vowels.contains(s.charAt(i)) ? 1 : 0;
		}
		int answer = count;

		// Slide the window to the right, focus on the added character and the
		// removed character and update "count". Record the largest "count".
		for (int i = k; i < s.length(); i++) {
			count += vowels.contains(s.charAt(i)) ? 1 : 0;
			count -= vowels.contains(s.charAt(i - k)) ? 1 : 0;
			answer = Math.max(answer, count);
		}

		return answer;
	}

	@Test
	public void case1() {
		assertEquals(3, maxVowels("abciiidef", 3));
	}

	@Test
	public void case2() {
		assertEquals(2, maxVowels("aeiou", 2));
	}

	@Test
	public void case3() {
		assertEquals(2, maxVowels("leetcode", 3));
	}

	@Test
	public void case4() {
		assertEquals(3, maxVowels("tnfazcwrryitgacaabwm", 4));
	}

}
