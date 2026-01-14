package com.leatcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LargestAltitudeTest {
	/**
	 * https://leetcode.com/problems/find-the-highest-altitude/?envType=study-plan-v2&envId=leetcode-75
	 * 
	 * here is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.

 

Example 1:

Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.

Example 2:

Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.

 

Constraints:

    n == gain.length
    1 <= n <= 100
    -100 <= gain[i] <= 100


	 * @param nums
	 * 
	 * beats 100%  memory beasts 11.28%
	 */
	public static int largestAltitude(int[] gain) {
		int highest = 0;
		int base = 0;
		for (int x : gain) {
			base += x;
			if (base > highest ) {
				highest = base;
			}
		}
		return highest;
	}

	@Test
	void case1() {
		assertEquals(1, largestAltitude(new int[] { -5,1,5,0,-7 }));
	}

	@Test
	void case2() {
		assertEquals(0, largestAltitude(new int[] { -4,-3,-2,-1,4,3,2 }));
	}

}
