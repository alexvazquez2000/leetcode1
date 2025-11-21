package com.leatcode.util;

import java.util.List;

/**
 * Utilities to help test recurring array/lists
 * 
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class Helper {
	public static boolean testArrayResponse(int[] response, int[] expected) {
		if (response.length != expected.length) {
			return false;
		}
		for (int x = 0; x < response.length; x++) {
			if (response[x] != expected[x]) {
				return false;
			}
		}
		return true;
	}

	public static boolean testBooleanArray(List<Boolean> response, boolean[] expected) {
		if (response.size() != expected.length) {
			return false;
		}
		System.out.print("response " + response + "\nexpected [");
		for (int x = 0; x < expected.length; x++) {
			System.out.print(expected[x] + ",");
		}
		System.out.print("] \t");

		for (int x = 0; x < response.size(); x++) {
			if (response.get(x) != expected[x]) {
				System.out.println("false");
				return false;
			}
		}
		System.out.println("true");
		return true;
	}

}
