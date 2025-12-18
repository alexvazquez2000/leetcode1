package com.leatcode.easy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

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

}
