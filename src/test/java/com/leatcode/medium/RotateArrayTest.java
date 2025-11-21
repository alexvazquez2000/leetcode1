package com.leatcode.medium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.leatcode.util.Helper;

/**
 * https://leetcode.com/problems/rotate-array/description/ 189. Rotate Array
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3 Output: [5,6,7,1,2,3,4] Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to the right:
 * [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * 
 * Input: nums = [-1,-100,3,99], k = 2 Output: [3,99,-1,-100] Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3] rotate 2 steps to the right:
 * [3,99,-1,-100]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 -231 <= nums[i] <= 231 - 1 0 <= k <= 105
 * 
 * 
 * 
 * Follow up:
 * 
 * Try to come up with as many solutions as you can. There are at least three
 * different ways to solve this problem. Could you do it in-place with O(1)
 * extra space?
 * 
 * 
 */
public class RotateArrayTest {
	public static void rotate_not_good_time_exceeded(int[] nums, int k) {
		for (int n = 0; n < k; n++) {
			int last = nums[nums.length - 1];
			for (int i = nums.length - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = last;
		}
	}

	public static void rotate_OK_but_not_best(int[] nums, int k) {
		while (k > nums.length) {
			k -= nums.length;
		}
		int[] last = new int[k];
		for (int n = 0; n < k; n++) {
			last[n] = nums[nums.length - k + n];
		}
		for (int i = nums.length - 1 - k; i >= 0; i--) {
			nums[i + k] = nums[i];
		}
		for (int i = 0; i < k; i++) {
			nums[i] = last[i];
		}
	}

	// Best solution O(n) with space O(1)
	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		// reverse entire list, so the last k elements are at the front
		reverse(nums, 0, nums.length);
		reverse(nums, 0, k);
		reverse(nums, k, nums.length);
	}

	private static void reverse(int[] nums, int start, int end) {
		for (int i = 0; i < (end - start) / 2; i++) {
			int t = nums[start + i];
			nums[start + i] = nums[end - 1 - i];
			nums[end - 1 - i] = t;
		}
	}

	@Test
	public void case1() {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 3);
		assertTrue(Helper.testArrayResponse(nums, new int[] { 5, 6, 7, 1, 2, 3, 4 }));
	}

	@Test
	public void case2() {
		int[] nums = new int[] { -1, -100, 3, 99 };
		rotate(nums, 2);
		assertTrue(Helper.testArrayResponse(nums, new int[] { 3, 99, -1, -100 }));
	}

	@Test
	public void case3() {
		int[] nums = new int[] { -1 };
		rotate(nums, 2);
		assertTrue(Helper.testArrayResponse(nums, new int[] { -1 }));
	}

	@Test
	public void case4() {
		int[] nums = new int[] { 1, 2 };
		rotate(nums, 5);
		assertTrue(Helper.testArrayResponse(nums, new int[] { 2, 1 }));
	}

}
