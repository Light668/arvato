package de.arvato.Aufgabe2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.arvato.Aufgabe2.domain.Product;
import de.arvato.Aufgabe2.services.ProductAnalyzer;

public class ProductAnalyzerTest {

	ProductAnalyzer pa;
	Product p1;
	Product p2;
	Product p3;
	Product p4;
	Product p5;
	Product p6;
	Product p7;
	Product p8;
	Product p9;
	Product p10;

	@BeforeEach
	public void setUp() {
		p1 = new Product("product1", "DE-NRW", 176F, false, 38);
		p2 = new Product("product2", "CN", 16F, true, 231);
		p3 = new Product("product3", "BG", 276F, false, 134);
		p4 = new Product("product4", "DE", 346F, false, 1853);
		p5 = new Product("product5", "CN-HK", 136F, false, 657);
		p6 = new Product("product6", "AN", 6F, true, 2);
		p7 = new Product("product7", "DE", 56F, false, 789);
		p8 = new Product("product8", "IT", 216F, false, 167);
		p9 = new Product("product9", "FR", 73F, false, 965);
		p10 = new Product("product10", "CN", 42F, true, 42);
		pa = new ProductAnalyzer();
	}

	@Test
	public void test() {
		Product[] productArray = { p2, p3, p5, p6, p8, p9 };
		JSONObject jo = new JSONObject();
		jo = pa.getResult(productArray);
		assertEquals(jo.getString("mostExpensiveProduct"), "product3");
		assertEquals(jo.getString("cheapestProduct"), "product6");
		assertEquals(jo.getString("mostPopularProduct"), "product9");
		assertEquals(jo.getBoolean("containsFragileProducts"), true);
		assertEquals(jo.getJSONArray("chineseProducts").length(), 2);
		assertEquals(jo.getJSONArray("chineseProducts").get(1), "product5");
	}

	// test with empty productArry
	@Test
	public void testEmpty() {
		Product[] productArray = {};
		JSONObject jo = new JSONObject();
		jo = pa.getResult(productArray);
		assertEquals(jo.getString("mostExpensiveProduct"), "");
		assertEquals(jo.getString("cheapestProduct"), "");
		assertEquals(jo.getBoolean("containsFragileProducts"), false);
	}

	// Test with duplicates
	@Test
	public void testDupes() {
		Product[] productArray = { p1, p1 };
		JSONObject jo = new JSONObject();
		jo = pa.getResult(productArray);
		assertEquals(jo.getString("mostExpensiveProduct"), "product1");
		assertEquals(jo.getJSONArray("germanProducts").length(), 2);
		assertEquals(jo.getJSONArray("germanProducts").get(0), "product1");
	}
}
