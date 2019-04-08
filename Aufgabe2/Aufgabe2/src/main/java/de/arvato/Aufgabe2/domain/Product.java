package de.arvato.Aufgabe2.domain;

public class Product {

	
	private String name;
	private String countryOfOrigin;
	private double price;
	private boolean isFragile;
	private int timesPurchased;
	
	// getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isFragile() {
		return isFragile;
	}
	public void setFragile(boolean isFragile) {
		this.isFragile = isFragile;
	}
	public int getTimesPurchased() {
		return timesPurchased;
	}
	public void setTimesPurchased(int timesPurchased) {
		this.timesPurchased = timesPurchased;
	}
	// Contructor
	public Product(String name, String countryOfOrigin, float price, boolean isFragile, int timesPurchased) {
		this.name = name;
		this.countryOfOrigin = countryOfOrigin;
		this.price = price;
		this.isFragile = isFragile;
		this.timesPurchased = timesPurchased;
	}

}
