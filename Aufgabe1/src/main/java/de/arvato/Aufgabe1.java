package de.arvato;
import com.google.gson.JsonObject;

/**
 * @author Timo Radtke
 *
 */
public class Aufgabe1 {
	
	/*
	 * 1) Create new Object ListUtilities lu 
	 * 2) Get the resulting JsonObject using lu.getResult method 
	 * 3) Print JSON object in console
	 */
	public static void main(String[] args) {
		ListUtilities lu = new ListUtilities();
		JsonObject JsonResult = lu.getResult("List1.txt", "List2.txt");
		System.out.println(JsonResult);
	}

}
