package com.leatcode.medium;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 =
 * 807.
 * 
 * Example 2:
 * 
 * Input: l1 = [0], l2 = [0] Output: [0]
 * 
 * Example 3:
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in each linked list is in the range [1, 100]. 0 <=
 * Node.val <= 9 It is guaranteed that the list represents a number that does
 * not have leading zeros.
 * 
 * 
 * 
 */
class AddTwoNumbersTest {
	// beats 4.30% memory beats 8.48
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<Integer> temp = new ArrayList<>();
		boolean done = false;
		int carry = 0;
		while (!done) {
			int a = 0;
			int b = 0;
			if (l1 != null) {
				a = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				b = l2.val;
				l2 = l2.next;
			}
			a = a + b + carry;
			if (a >= 10) {
				carry = 1;
				a -= 10;
			} else {
				carry = 0;
			}
			temp.add(a);
			System.out.print(a);
			if (l1 == null && l2 == null) {
				if (carry == 0) {
					done = true;
				} else {
					done = false;
				}
			} else {
				done = false;
			}
		}
		System.out.println();

		return makeList(temp.toArray(new Integer[temp.size()]));
	}

	private ListNode makeList(Integer[] ints) {
		ListNode next = null;
		for (int i = ints.length - 1; i >= 0; i--) {
			next = new ListNode(ints[i], next);
		}
		return next;
	}

	@Test
	void case1() {
		ListNode l1 = makeList(new Integer[] { 2, 4, 3 });
		ListNode l2 = makeList(new Integer[] { 5, 6, 4 });
		ListNode response = addTwoNumbers(l1, l2);
		assertTrue(validateEqual(new int[] { 7, 0, 8 }, response));
	}

	@Test
	void case2() {
		ListNode l1 = makeList(new Integer[] { 0 });
		ListNode l2 = makeList(new Integer[] { 0 });
		ListNode response = addTwoNumbers(l1, l2);
		assertTrue(validateEqual(new int[] { 0 }, response));
	}

	@Test
	void case3() {
		ListNode l1 = makeList(new Integer[] { 9, 9, 9, 9, 9, 9, 9 });
		ListNode l2 = makeList(new Integer[] { 9, 9, 9, 9 });
		ListNode response = addTwoNumbers(l1, l2);
		assertTrue(validateEqual(new int[] { 8, 9, 9, 9, 0, 0, 0, 1 }, response));
	}

	private boolean validateEqual(int[] expected, ListNode response) {
		int i = 0;
		int countNodes = 0;
		while (response != null) {
			if (response.val != expected[i++]) {
				return false;
			}
			countNodes++;
			response = response.next;
		}
		if (expected.length != countNodes) {
			return false;
		}
		return true;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
