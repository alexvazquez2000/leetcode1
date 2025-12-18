package com.leatcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class MajorityTest {
	public static int majorityElement(int[] nums) {

		HashMap<Integer, Integer> seenEntries = new HashMap<>();
		for (int x = 0; x < nums.length; x++) {
			if (seenEntries.containsKey(nums[x])) {
				seenEntries.put(nums[x], seenEntries.get(nums[x]) + 1);
			} else {
				seenEntries.put(nums[x], 1);
			}
		}
		int response = -1;
		int maxValue = 0;
		for (int temp : seenEntries.keySet()) {
			if (seenEntries.get(temp) > maxValue) {
				maxValue = seenEntries.get(temp);
				response = temp;
			}

		}
		return response;
	}

	@Test
	void majorityElementTest() {
		assertEquals(3, majorityElement(new int[] { 3, 2, 3 }));
		assertEquals(2, majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}

}
