package de.arvato.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfitableFlearsTest {

	static List<Flear> flears;

	// set up Flear Objects and flears ArrayList<Flear> for Tests
	@BeforeEach
	public void setUp() {
		Flear F1 = new Flear("A1", 10, 3);
		Flear F2 = new Flear("A2", 20, 2);
		Flear F3 = new Flear("A3", 30, 5);
		Flear F4 = new Flear("A4", 40, 7);
		Flear F5 = new Flear("A5", 50, 5);
		Flear F6 = new Flear("A6", 60, 9);

		flears = new ArrayList<Flear>();

		flears.add(F1);
		flears.add(F2);
		flears.add(F3);
		flears.add(F4);
		flears.add(F5);
		flears.add(F6);
	}

	// Testing with money = 70F, asserting getOptimalValue returns 12
	@Test
	public void testWithMoney70() {
		int result_test = ProfitableFlears.getOptimalValue(70F, flears);
		assertEquals(12, result_test);
	}

	// Testing with money = 130F, asserting getOptimalValue returns 21
	@Test
	public void testWithMoney130() {
		int result_test = ProfitableFlears.getOptimalValue(130F, flears);
		assertEquals(21, result_test);
	}

	// Testing with money = 40F, asserting getOptimalValue returns 8
	@Test
	public void testWithMoney40() {
		int result_test = ProfitableFlears.getOptimalValue(40F, flears);
		assertEquals(8, result_test);
	}

	// Testing with money = 0F, asserting getOptimalValue returns 0
	@Test
	public void testWithoutMoney() {
		int result_test = ProfitableFlears.getOptimalValue(0F, flears);
		assertEquals(0, result_test);
	}

	// Testing with money = 10000F, asserting getOptimalValue returns maximum = 31
	@Test
	public void testWithTooMuchMoney() {
		int result_test = ProfitableFlears.getOptimalValue(10000F, flears);
		assertEquals(31, result_test);
	}

	// Testing with empty List, asserting getOptimalValue returns 0
	@Test
	public void testWithEmptyList() {
		int result_test = ProfitableFlears.getOptimalValue(10000F, new ArrayList<Flear>());
		assertEquals(0, result_test);
	}
}
