package com.leatcode.medium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.leatcode.util.Helper;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 * 238. Product of Array Except Self Given an integer array nums, return an
 * array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4] Output: [24,12,8,6]
 * 
 * Example 2:
 * 
 * Input: nums = [-1,1,0,-3,3] Output: [0,0,9,0,0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 105 -30 <= nums[i] <= 30 The input is generated such that
 * answer[i] is guaranteed to fit in a 32-bit integer.
 * 
 * 
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 * 
 * 
 */
public class ProductOfArrayExceptSelfTest {

	/*
	 * 1,2,3,4 s 1 2 6 24 = 24 1 1 3 24 = 24 1 2 1 8 = 8 1 2 6 1 = 6
	 * 
	 * expect 24,12,8,6
	 * 
	 */
	// beats 87.92% of the solutions
	public static int[] productExceptSelf(int[] nums) {
		int[] response = new int[nums.length];
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		for (int x = 0; x < nums.length; x++) {
			if (x == 0) {
				left[x] = 1;
			}
			if (x < nums.length - 1) {
				left[x + 1] = nums[x] * left[x];
			}
		}
		for (int x = nums.length - 1; x >= 0; x--) {
			if (x == nums.length - 1) {
				right[x] = 1;
			}
			if (x > 0) {
				right[x - 1] = nums[x] * right[x];
			}
		}
		for (int x = 0; x < nums.length; x++) {
			response[x] = left[x] * right[x];
		}
		return response;
	}

	@Test
	public void case1() {
		assertTrue(Helper.testArrayResponse(productExceptSelf(new int[] { 1, 2, 3, 4 }), new int[] { 24, 12, 8, 6 }));
		//
	}

	@Test
	public void case2() {
		assertTrue(Helper.testArrayResponse(productExceptSelf(new int[] { -1, 1, 0, -3, 3 }),
				new int[] { 0, 0, 9, 0, 0 }));
	}

	@Test
	public void caseSolution() {
		assertTrue(Helper.testArrayResponse(productExceptSelf(new int[] { 4, 5, 1, 8, 2 }),
				new int[] { 80, 64, 320, 40, 160 }));
	}

}
