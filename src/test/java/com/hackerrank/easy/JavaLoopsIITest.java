package com.hackerrank.easy;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class JavaLoopsIITest {

	public static String sumSeries(int a, int b, int n) {
		StringBuilder line = new StringBuilder();
		for (int x = 0; x < n; x++) {
			int answer = a;
			System.out.println("a=" + answer);
			for (int j = 0; j <= x; j++) {
				int aa = (int) ((Math.pow(2, j)) * b);
				answer += aa;
				System.out.println("j=" + j + " answer=" + answer + " added=" + aa + "  (2^j)=" + (2 ^ j));
			}
			line.append(answer + " ");
		}
		return line.toString().trim();
	}

	@Test
	void test() {
		assertEquals("2 6 14 30 62 126 254 510 1022 2046", sumSeries(0, 2, 10));

	}

}
