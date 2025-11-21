package com.leatcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CanPlaceFlowersTest {

	/**
	 * https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
	 * 605. Can Place Flowers
	 * 
	 * You have a long flowerbed in which some of the plots are planted, and some
	 * are not. However, flowers cannot be planted in adjacent plots.
	 * 
	 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
	 * and 1 means not empty, and an integer n, return true if n new flowers can be
	 * planted in the flowerbed without violating the no-adjacent-flowers rule and
	 * false otherwise.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: flowerbed = [1,0,0,0,1], n = 1 Output: true
	 * 
	 * Example 2:
	 * 
	 * Input: flowerbed = [1,0,0,0,1], n = 2 Output: false
	 * 
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= flowerbed.length <= 2 * 104 flowerbed[i] is 0 or 1. There are no two
	 * adjacent flowers in flowerbed. 0 <= n <= flowerbed.length
	 * 
	 * 
	 * @param flowerbed
	 * @param n
	 * @return
	 */

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0) {
			return true;
		}
		boolean result = false;
		int beds = flowerbed.length;
		int bedsAvailable = 0;
		for (int x = 0; x < beds; x++) {
			if (isBedAvailable(flowerbed, x)) {
				bedsAvailable++;

				if (bedsAvailable == n) {
					return true;
				} else if (n > 1) {
					flowerbed[x] = 1;
					return canPlaceFlowers(flowerbed, n - 1);
				}
			}
		}
		return result;
	}

	// no need to recurse, just mark it and check the next entry
	public boolean canPlaceFlowersOptimal(int[] flowerbed, int n) {
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			// Check if the current plot is empty.
			if (flowerbed[i] == 0) {
				// Check if the left and right plots are empty.
				boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
				boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

				// If both plots are empty, we can plant a flower here.
				if (emptyLeftPlot && emptyRightPlot) {
					flowerbed[i] = 1;
					count++;
					if (count >= n) {
						return true;
					}
				}
			}
		}
		return count >= n;
	}

	private boolean isBedAvailable(int[] flowerbed, int x) {
		if (flowerbed[x] == 1) {
			return false;
		} else if (x == 0
				&& ((flowerbed[0] == 0 && flowerbed.length == 1) || (flowerbed[0] == 0 && flowerbed[1] == 0))) {
			return true;
		} else if (x > 0 && x == flowerbed.length - 1 && (flowerbed[x] == 0 && flowerbed[x - 1] == 0)) {
			return true;
		} else if (x > 0 && x < flowerbed.length - 1
				&& (flowerbed[x - 1] == 0 && flowerbed[x] == 0 && flowerbed[x + 1] == 0)) {
			return true;
		}
		return false;
	}

	@Test
	void test() {
		assertEquals(true, canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
		assertEquals(false, canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
		assertEquals(false, canPlaceFlowers(new int[] { 1, 0, 0, 0, 0, 1 }, 2));
		assertEquals(true, canPlaceFlowers(new int[] { 1, 0, 1, 0, 1, 0, 1 }, 0));
		assertEquals(true, canPlaceFlowers(new int[] { 0 }, 1));
	}

}
