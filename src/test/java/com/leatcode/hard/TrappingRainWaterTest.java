package com.leatcode.hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * May 27, 2025 https://leetcode.com/problems/trapping-rain-water/description/
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6 Explanation: The above
 * elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
 * are being trapped.
 * 
 * | BwwwGGwB |_XwBBwBBBBBB 012345678901
 * 
 * Example 2:
 * 
 * Input: height = [4,2,0,3,2,5] Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * n == height.length 1 <= n <= 2 * 104 0 <= height[i] <= 105
 * 
 * 
 * 10:30am
 */
class TrappingRainWaterTest {
	public int trap(int[] height) {
		int[] highestLeftToRight = new int[height.length];
		int[] highestRightToLeft = new int[height.length];

		int waterLevel = 0;
		for (int x = 0; x < height.length; x++) {
			if (waterLevel < height[x]) {
				waterLevel = height[x];
			}
			highestLeftToRight[x] = waterLevel;
		}

		waterLevel = 0;
		for (int x = height.length - 1; x >= 0; x--) {
			if (waterLevel < height[x]) {
				waterLevel = height[x];
			}
			highestRightToLeft[x] = waterLevel;
		}

		// collect water
		int waterCollected = 0;
		for (int x = 0; x < height.length; x++) {
			waterCollected += Math.min(highestLeftToRight[x], highestRightToLeft[x]) - height[x];
		}
		return waterCollected;
	}

	@Test
	void case1() {
		assertEquals(6, trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}

	@Test
	void case2() {
		assertEquals(9, trap(new int[] { 4, 2, 0, 3, 2, 5 }));
	}

	@Test
	void case3() {
		// missed this test
		assertEquals(1, trap(new int[] { 4, 2, 3 }));
	}

	@Test
	void case3a() {
		// missed this test
		assertEquals(1, trap(new int[] { 3, 2, 4 }));
	}

}
