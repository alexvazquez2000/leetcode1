package com.leatcode.medium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * 334. Increasing Triplet Subsequence
 * 
 * Given an integer array nums, return true if there exists a triple of indices
 * (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such
 * indices exists, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4,5] Output: true Explanation: Any triplet where i < j <
 * k is valid.
 * 
 * Example 2:
 * 
 * Input: nums = [5,4,3,2,1] Output: false Explanation: No triplet exists.
 * 
 * Example 3:
 * 
 * Input: nums = [2,1,5,0,4,6] Output: true Explanation: The triplet (3, 4, 5)
 * is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5 * 105 -231 <= nums[i] <= 231 - 1
 * 
 * 
 * Follow up: Could you implement a solution that runs in O(n) time complexity
 * and O(1) space complexity?
 */
public class IncreasingTripletSubsequenceTest {

	public static boolean increasingTriplet_Bad_Failed_case4(int[] nums) {
		// this assumed the numbers were consecutive
		boolean found = false;
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(nums[0]);
		for (int x = 1; x < nums.length; x++) {
			if (queue.peek() > nums[x]) {
				queue.clear();
			}
			queue.push(nums[x]);
			if (queue.size() == 3) {
				return true;
			}
		}
		return found;
	}

	/**
	 * Failed on test case 7 - and has space O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean increasingTriplet_Bad_case7(int[] nums) {
		boolean found = false;
		IncreasingTripletSubsequenceTest temp = new IncreasingTripletSubsequenceTest();
		Tree tree = temp.new Tree(nums[0]);

		for (int x = 1; x < nums.length; x++) {
			tree.add(nums[x]);
		}
		System.out.println("---------");
		Tree t = tree;
		while (t != null) {
			System.out.println(t.value + " has " + t.children + " children");
			if (t.children >= 3) {
				return true;
			}
			t = t.left;
		}

		return found;
	}

	public class Tree {
		private Tree left;
		private Tree right;
		private int children = 1;
		int value;

		public Tree(int v) {
			value = v;
		}

		public void add(int i) {
			if (i <= value) {
				if (left == null) {
					left = new Tree(i);
				} else {
					left.add(i);
				}
			} else {
				if (right == null) {
					right = new Tree(i);
				} else {
					right.add(i);
				}
				children = right.children + 1;
			}

		}
	}

	// after seeing the solution
	public static boolean increasingTriplet(int[] nums) {
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= first) {
				first = n;
			} else if (n <= second) {
				second = n;
			} else {
				return true;
			}
		}
		return false;
	}

	@Test
	public void case1() {
		assertTrue(increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
	}

	@Test
	public void case2() {
		assertFalse(increasingTriplet(new int[] { 5, 4, 3, 2, 1 }));
	}

	@Test
	public void case3() {
		assertTrue(increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }));
	}

	@Test
	public void case4() {
		assertTrue(increasingTriplet(new int[] { 20, 100, 10, 12, 5, 13 }));
	}

	@Test
	public void case5() {
		assertFalse(increasingTriplet(new int[] { 0, 4, 2, 1, 0, -1, -3 }));
	}

	@Test
	public void case6() {
		assertFalse(increasingTriplet(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
	}

	@Test
	public void case7() {
		assertTrue(increasingTriplet(new int[] { 1, 5, 0, 4, 1, 3 }));
	}

	@Test
	public void case8() {
		assertFalse(increasingTriplet(new int[] { 1, 1, -2, 6 }));
	}

}
