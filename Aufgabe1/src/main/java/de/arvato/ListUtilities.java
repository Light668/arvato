package de.arvato;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ListUtilities {
	/*
	 * Reading file content via Scanner and return a JsonArray which contains the
	 * names in file
	 */
	private JsonArray getNamesFromFile(File file) {
		Scanner sc;
		JsonArray names = new JsonArray();
		try {
			sc = new Scanner(file);
			while (sc.hasNext()) {
				String s1 = sc.nextLine();
				names.add(s1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return names;
	}

	private JsonArray removeDuplicates(JsonArray names) {
		for (int i = 0; i < names.size(); i++) {
			for (int j = i + 1; j < names.size(); j++) {
				if (names.get(i).equals(names.get(j))) {
					names.remove(j);
					j--;
				}
			}
		}
		return names;
	}

	public JsonObject getResult(String filename1, String filename2) {

		/*
		 * Loading files List1.txt and List2.txt located in resources folder default
		 * path: /Aufgabe1_arvato/src/main/resources/List1.txt
		 */
		File fileList1;
		File fileList2;
		JsonArray onlyInList1 = new JsonArray();
		JsonArray onlyInList2 = new JsonArray();
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			fileList1 = new File(classloader.getResource(filename1).getFile());
			onlyInList1 = getNamesFromFile(fileList1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			fileList2 = new File(classloader.getResource(filename2).getFile());
			onlyInList2 = getNamesFromFile(fileList2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// removing Duplicates from JsonArrays
		onlyInList1 = removeDuplicates(onlyInList1);
		onlyInList2 = removeDuplicates(onlyInList2);

		JsonArray inBothLists = new JsonArray();
		// Comparing names in JsonArrays and create result arrays
		for (int i = 0; i < onlyInList1.size(); i++) {
			JsonElement name = onlyInList1.get(i);
			for (int j = 0; j < onlyInList2.size(); j++) {
				if (name.equals(onlyInList2.get(j))) {
					inBothLists.add(onlyInList2.get(j));
					onlyInList2.remove(j);
					j--;					
				}
			}
			if (inBothLists.contains(onlyInList1.get(i))) {
				onlyInList1.remove(i);
				i--;
			}
		}

		// Create result as JSON object
		JsonObject result = new JsonObject();
		result.add("onlyInList1", onlyInList1);
		result.add("onlyInList2", onlyInList2);
		result.add("inBothLists", inBothLists);
		return result;
	}
}
