package de.arvato.Aufgabe2.services;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import de.arvato.Aufgabe2.domain.Product;

@Service
public class ProductAnalyzer {

	public JSONObject getResult(Product[] productArray) {
		// Initializing Json object
		double maxPrice = 0;
		double minPrice = Double.MAX_VALUE;
		int maxSales = 0;
		boolean containsFragileProducts = false;
		ArrayList<String> germanProducts = new ArrayList<String>();
		ArrayList<String> chineseProducts = new ArrayList<String>();

		JSONObject result = new JSONObject();
		result.put("mostExpensiveProduct", "");
		result.put("cheapestProduct", "");
		result.put("mostPopularProduct", "");
		result.put("containsFragileProducts", containsFragileProducts);
		
		// Iterating and analyzing products metadata 
		for (int i = 0; i < productArray.length; i++) {
			if (productArray[i].getPrice() >= maxPrice) {
				result.put("mostExpensiveProduct", productArray[i].getName());
				maxPrice = productArray[i].getPrice();
			}
			if (productArray[i].getPrice() <= minPrice) {
				result.put("cheapestProduct", productArray[i].getName());
				minPrice = productArray[i].getPrice();
			}
			if (productArray[i].isFragile() == true) {
				containsFragileProducts = true;
				result.put("containsFragileProducts", true);
			}
			if (productArray[i].getTimesPurchased() >= maxSales) {
				result.put("mostPopularProduct", productArray[i].getName());
				maxSales = productArray[i].getTimesPurchased();
			}
			if (productArray[i].getCountryOfOrigin().substring(0, 2).equals("DE")) {
				germanProducts.add(productArray[i].getName());
			} else if (productArray[i].getCountryOfOrigin().substring(0, 2).equals("CN")) {
				chineseProducts.add(productArray[i].getName());
			}
		}
		result.put("chineseProducts", chineseProducts);
		result.put("germanProducts", germanProducts);

		return result;
	}
}
