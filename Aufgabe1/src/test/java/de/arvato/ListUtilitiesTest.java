package de.arvato;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ListUtilitiesTest {

	ListUtilities lu;
	String s1;
	String s2;
	String s3;
	String s4;
	String s5;

	@BeforeEach
	public void setUp() {
		lu = new ListUtilities();
		s1 = "List1.txt";
		s2 = "List2.txt";
		s3 = "List3.txt";
		s4 = "List4.txt";
		s5 = "Empty.txt";

	}

	// Testing Entries in onlyInList1, onlyInList2 and inBothLists
	@Test
	public void test1() {
		JsonObject jo = lu.getResult(s1, s2);
		JsonArray onl1 = jo.getAsJsonArray("onlyInList1");
		assertEquals("Ralf Schmidt", onl1.get(0).getAsString());
		assertEquals("Angelina Jolie", onl1.get(2).getAsString());
		assertEquals("Bruce Willis", onl1.get(6).getAsString());

		onl1 = jo.getAsJsonArray("onlyInList2");
		assertEquals("Donald Trump", onl1.get(0).getAsString());
		assertEquals("Jennifer Lawrence", onl1.get(3).getAsString());
		assertEquals("Vin Diesel", onl1.get(7).getAsString());

		onl1 = jo.getAsJsonArray("inBothLists");
		assertEquals("Angela Merkel", onl1.get(0).getAsString());
		assertEquals("Timo Radtke", onl1.get(1).getAsString());

	}

	// Testing with empty List
	@Test
	public void test2() {
		JsonObject jo = lu.getResult(s3, s5);
		JsonArray test = jo.getAsJsonArray("onlyInList1");
		assertEquals("Christiano Ronaldo", test.get(0).getAsString());
		assertEquals("Mats Hummels", test.get(4).getAsString());

		test = jo.getAsJsonArray("onlyInList2");
		assertEquals(0, test.size());

		test = jo.getAsJsonArray("inBothLists");
		assertEquals(0, test.size());

		jo = lu.getResult(s5, s3);
		test = jo.getAsJsonArray("onlyInList1");
		assertEquals(0, test.size());

		test = jo.getAsJsonArray("onlyInList2");
		assertEquals("Christiano Ronaldo", test.get(0).getAsString());
		assertEquals("Mats Hummels", test.get(4).getAsString());

		test = jo.getAsJsonArray("inBothLists");
		assertEquals(0, test.size());

	}
	// Test with identical lists
	@Test
	public void test3() {
		JsonObject jo = lu.getResult(s4, s4);
		JsonArray test = jo.getAsJsonArray("onlyInList1");
		assertEquals(0, test.size());
		
		test = jo.getAsJsonArray("onlyInList2");
		assertEquals(0, test.size());
		
		test = jo.getAsJsonArray("inBothLists");
		assertEquals(10, test.size());
	}
}
