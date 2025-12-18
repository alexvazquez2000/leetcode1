package com.leatcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesTest {
	/**
	 * Given an integer array nums sorted in non-decreasing order, remove the
	 * duplicates in-place such that each unique element appears only once. The
	 * relative order of the elements should be kept the same. Then return the
	 * number of unique elements in nums.
	 * 
	 * Consider the number of unique elements of nums to be k, to get accepted, you
	 * need to do the following things: Change the array nums such that the first k
	 * elements of nums contain the unique elements in the order they were present
	 * in nums initially. The remaining elements of nums are not important as well
	 * as the size of nums.
	 * 
	 * Return k.
	 * 
	 * 1,1,2,2
	 * 
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		System.out.print("input\t");
		for (int x = 0; x < nums.length; x++) {
			System.out.print(nums[x] + ",");
		}
		System.out.println();

		int k = 0;
		int lastNumber = -999;
		int writeAtIndex = -1;
		int i = 0;
		while (i < nums.length) {
			if (nums[i] > lastNumber) {
				if (lastNumber != -999) {
					nums[writeAtIndex] = nums[i];
					writeAtIndex++;
				} else {
					writeAtIndex = i + 1;
				}
				lastNumber = nums[i];
				k++;
			}
			i++;
		}

		System.out.print(k + "\t");
		for (int x = 0; x < nums.length; x++) {
			System.out.print(nums[x] + ",");
		}
		System.out.println("-----------------");
		return k;
	}

	@Test
	void removeDuplicatesTest() {
		assertEquals(2, removeDuplicates(new int[] { 1, 1, 2 }));
		assertEquals(5, removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}

}
