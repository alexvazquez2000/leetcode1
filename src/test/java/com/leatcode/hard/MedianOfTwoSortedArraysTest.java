package com.leatcode.hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MedianOfTwoSortedArraysTest {
/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

 

Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106


 */
	/** start ate 1:06PM - 3pm  runtime beats 99.97%  --  memory beats 31.77%/*
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int count = 0;
		int stopAt = (nums1.length + nums2.length ) /2;
		int totalNumber = nums1.length + nums2.length;
		//System.out.println("total number = " + totalNumber);
		//if ( (totalNumber %2)==0) {
		//	System.out.println("need 2 elements around " + (stopAt -1) + " and " + stopAt );
		//} else {
		//	System.out.println("need element at " + stopAt);
		//}
		int[] combined = new int[nums1.length + nums2.length];
		int i =0;
		int j =0;
		while (count <= stopAt ) {
			//System.out.println("compare " + nums1[i] + " vs " +  nums2[j]);
			if (i < nums1.length && j < nums2.length) {
				if (nums1[i] > nums2[j]) {
					combined[count] =  nums2[j];
					j++;
				} else {
					combined[count] =  nums1[i];
					i++;
				}
			} else if (i == nums1.length ) {
				combined[count] =  nums2[j];
				j++;
			} else if (j == nums2.length ) {
				combined[count] =  nums1[i];
				i++;
			}
			count++;
		}
		
		//System.out.println( "combined[" + stopAt + "]=" + combined[stopAt] + "\n");
		if ( (totalNumber %2)==0) {
			return (combined[stopAt] + combined[stopAt-1])/2.0d;
		} else {
			return combined[stopAt];
		}
	}
	
	@Test
	void case1() {
		assertEquals(2.0, findMedianSortedArrays(new int[] {1,3}, new int[] {2}));
	}

	@Test
	void case1reverse() {
		assertEquals(2.0, findMedianSortedArrays(new int[] {2}, new int[] {1, 3}));
	}

	@Test
	void case2() {
		assertEquals(2.5, findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
	}

	@Test
	void caseFirstArrayIsEmpty() {
		assertEquals(1, findMedianSortedArrays(new int[] {}, new int[] {1}));
	}

	@Test
	void caseASecondArrayIsEmpty() {
		assertEquals(1.5, findMedianSortedArrays(new int[] {1,2}, new int[] {}));
	}

}
