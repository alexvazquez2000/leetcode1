package com.leatcode.easy.gusto;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class Gusto_PayMoneyTest {

	// From Interview with Gusto on April 10, 2025
	// pay as equally as possible
	public static Map<String, Integer> pay(Map<String, Integer> limits, int amount) {
		Map<String, Integer> payments = new HashMap<>();
		int oweMoneyCount = 0;
		for (Entry<String, Integer> entry : limits.entrySet()) {
			payments.put(entry.getKey(), 0);
			if (entry.getValue() > 0) {
				oweMoneyCount++;
			}
		}
		System.out.println("owe money to " + oweMoneyCount + " providers");
		int paymentAmount = 0;
		while (paymentAmount < amount && oweMoneyCount > 0) {
			int maxPay = amount / oweMoneyCount;
			oweMoneyCount = 0;
			for (Entry<String, Integer> entry : limits.entrySet()) {
				Integer paid = payments.get(entry.getKey());
				int owed = entry.getValue() - paid;
				int pay = Math.min(owed, maxPay);
				payments.put(entry.getKey(), paid + pay);
				System.out.println("paying " + entry.getKey() + " amount " + pay);
				paymentAmount += pay;
				if (owed - pay > 0) {
					oweMoneyCount++;
				}
			}
		}
		System.out.println("paid=" + paymentAmount);
		return payments;
	}

	private void print(String caseDesc, Map<String, Integer> map) {
		System.out.println(caseDesc);
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=" +entry.getValue());
		}
		System.out.println();
	}

	static Map<String, Integer> owed = new HashMap<>();
	@BeforeEach
	void setup() {
		owed.put("a", 10);
		owed.put("b", 10);
		owed.put("c", 10);
		owed.put("d", 10);
	}
	
	@Test
	void exactChange() {
		print("case 1 - pay ", pay(owed, 40));
	}

	@Test
	void notEnoughMoneyToPayAll() {
		owed.put("a", 100);
		print("case 2 - pay (not enough money)", pay(owed, 40));
	}

	@Test
	void payAllSpareChange() {
		owed.put("a", 1);
		//we owe 31 and have extra money left
		print("case 3 - pay (too much money)", pay(owed, 40));
	}

}
