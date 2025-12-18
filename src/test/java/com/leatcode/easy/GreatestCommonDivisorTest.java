package com.leatcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GreatestCommonDivisorTest {
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
