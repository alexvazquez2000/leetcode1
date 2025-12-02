package com.leatcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1

 

Constraints:

    n == height.length
    2 <= n <= 10^5
    0 <= height[i] <= 10^4


 */
class ContainerWithMostWaterTest {
	
	/**
	 * runtime beats 92.08%  - memory beats 5.77% 
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length -1;
		int maxWater = -1;
		while (left < right) {
			int t = Math.min(height[left], height[right]) * (right - left);
			if (maxWater < t) {
				maxWater = t;
			};
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxWater;
	}

	@Test
	void case1() {
		assertEquals(49, maxArea( new int[] {1,8,6,2,5,4,8,3,7}));
	}

	@Test
	void case2() {
		assertEquals(1, maxArea( new int[] {1,1}));
	}

}
