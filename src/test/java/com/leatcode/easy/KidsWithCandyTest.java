package com.leatcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.leatcode.util.Helper;

/**
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
 * 1431. Kids With the Greatest Number of Candies
 * 
 * There are n kids with candies. You are given an integer array candies, where
 * each candies[i] represents the number of candies the ith kid has, and an
 * integer extraCandies, denoting the number of extra candies that you have.
 * 
 * Return a boolean array result of length n, where result[i] is true if, after
 * giving the ith kid all the extraCandies, they will have the greatest number
 * of candies among all the kids, or false otherwise.
 * 
 * Note that multiple kids can have the greatest number of candies.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: candies = [2,3,5,1,3], extraCandies = 3 Output:
 * [true,true,true,false,true] Explanation: If you give all extraCandies to: -
 * Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the
 * kids. - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among
 * the kids. - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest
 * among the kids. - Kid 4, they will have 1 + 3 = 4 candies, which is not the
 * greatest among the kids. - Kid 5, they will have 3 + 3 = 6 candies, which is
 * the greatest among the kids.
 * 
 * Example 2:
 * 
 * Input: candies = [4,2,1,1,2], extraCandies = 1 Output:
 * [true,false,false,false,false] Explanation: There is only 1 extra candy. Kid
 * 1 will always have the greatest number of candies, even if a different kid is
 * given the extra candy.
 * 
 * Example 3:
 * 
 * Input: candies = [12,1,12], extraCandies = 10 Output: [true,false,true]
 * 
 * 
 * 
 * Constraints:
 * 
 * n == candies.length 2 <= n <= 100 1 <= candies[i] <= 100 1 <= extraCandies <=
 * 50
 * 
 * 
 */
class KidsWithCandyTest {
	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> response = new ArrayList<>();

		int maxCandies = 0;
		for (int x = 0; x < candies.length; x++) {
			if (candies[x] > maxCandies) {
				maxCandies = candies[x];
			}
		}
		for (int j = 0; j < candies.length; j++) {
			int withExtraCandies = candies[j] + extraCandies;
			boolean hasMore = false;
			System.out.println(withExtraCandies + " >= " + maxCandies);
			if (withExtraCandies >= maxCandies) {
				hasMore = true;
			}
			response.add(hasMore);
		}
		return response;

	}

	@Test
	void test() {
		assertTrue(Helper.testBooleanArray(kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3),
				new boolean[] { true, true, true, false, true }));
		assertTrue(Helper.testBooleanArray(kidsWithCandies(new int[] { 4, 2, 1, 1, 2 }, 1),
				new boolean[] { true, false, false, false, false }));
		assertTrue(Helper.testBooleanArray(kidsWithCandies(new int[] { 12, 1, 12 }, 10),
				new boolean[] { true, false, true }));
		assertTrue(Helper.testBooleanArray(kidsWithCandies(new int[] { 2, 8, 7 }, 1),
				new boolean[] { false, true, true }));
	}

}
