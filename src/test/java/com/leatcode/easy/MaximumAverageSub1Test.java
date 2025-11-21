package com.leatcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 * 643. Maximum Average Subarray I You are given an integer array nums
 * consisting of n elements, and an integer k.
 * 
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value. Any answer with a calculation error less
 * than 10-5 will be accepted.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,12,-5,-6,50,3], k = 4 Output: 12.75000 Explanation: Maximum
 * average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * 
 * Example 2:
 * 
 * Input: nums = [5], k = 1 Output: 5.00000
 * 
 * 
 * 
 * Constraints:
 * 
 * n == nums.length 1 <= k <= n <= 105 -104 <= nums[i] <= 104
 * 
 * 
 * 
 */
public class MaximumAverageSub1Test {

	// accepted first try - 45 minutes - beats 79.69% and memory beats 5.14%
	// O(n) for both run and memory
	public static double findMaxAverage_mine(int[] nums, int k) {
		int[] sums = new int[nums.length - k + 1];
		int i = 0;
		while (i < k) {
			sums[0] += nums[i];
			i++;
		}
		for (i = 1; i < sums.length; i++) {
			sums[i] = sums[i - 1] - nums[i - 1] + nums[i + k - 1];
		}
		int largestSum = Integer.MIN_VALUE;
		for (i = 0; i < sums.length; i++) {
			if (sums[i] > largestSum) {
				largestSum = sums[i];
			}
		}
		return (double) largestSum / k;
	}

	// Solution similar to mine with array but more efficient O(n) for both run and memory
	public static double findMaxAverage_On_On(int[] nums, int k) {
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
			System.out.println(i + "\t" + sum[i]);
		}
		double res = sum[k - 1] * 1.0 / k;
		for (int i = k; i < nums.length; i++) {
			res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
		}
		return res;
	}

	// most efficient O(n) complexity but just O(1) for memory
	public double findMaxAverage(int[] nums, int k) {
		double sum = 0;
		for (int i = 0; i < k; i++)
			sum += nums[i];
		double res = sum;
		for (int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[i - k];
			res = Math.max(res, sum);
		}
		return res / k;
	}

	@Test
	public void case1() {
		assertEquals(12.75000, findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4)); // 3 entries
	}

	@Test
	public void case2() {
		assertEquals(5.0000, findMaxAverage(new int[] { 5 }, 1));
	}

	@Test
	public void caseA() {
		assertEquals((49 / 3.0d), findMaxAverage(new int[] { 1, 12, 05, -6, 50, 3 }, 3)); // 4 entries
	}

	@Test
	public void caseB() {
		assertEquals((53 / 2.0d), findMaxAverage(new int[] { 1, 12, 05, -6, 50, 3 }, 2)); // 5 entries
	}

	@Test
	public void caseC() {
		assertEquals(50.0d, findMaxAverage(new int[] { 1, 12, 05, -6, 50, 3 }, 1)); // 6 entries
	}

}
