package com.leatcode.easy;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.leatcode.util.Helper;

/**
 * https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 * 283. Move Zeroes Given an integer array nums, move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 * Example 2:
 * 
 * Input: nums = [0] Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104 -231 <= nums[i] <= 231 - 1
 * 
 * 
 * Follow up: Could you minimize the total number of operations done?
 * 
 * @since 2025-04-01
 */
public class MoveZerosTest {

	// beats 99.39% - completed in about 20 minutes
	public void moveZeroes(int[] nums) {
		// count how many zeroes
		int zeroCount = 0;
		int index = 0;
		for (int i : nums) {
			if (i == 0) {
				zeroCount++;
			} else {
				nums[index++] = i;
			}
		}
		//
		// zero the last count elements
		for (int i = index; i < nums.length; i++) {
			nums[i] = 0;
		}
		System.out.println("not needed for the problem, but there are " + zeroCount + " zeros");
	}

	@Test
	public void case1() {
		int[] test = new int[] { 0, 1, 0, 3, 12 };
		moveZeroes(test);
		assertTrue(Helper.testArrayResponse(test, new int[] { 1, 3, 12, 0, 0 }));
	}

	@Test
	public void case2() {
		int[] test = new int[] { 0 };
		moveZeroes(test);
		assertTrue(Helper.testArrayResponse(test, new int[] { 0 }));
	}

}
