package de.arvato.Aufgabe2.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.arvato.Aufgabe2.domain.Product;
import de.arvato.Aufgabe2.services.ProductAnalyzer;

@RestController
@RequestMapping("/text")
public class ProductController {

	@Autowired
	private ProductAnalyzer pa;

	@PostMapping("/analyze")
	public String postMetadata(@RequestBody Product[] productArray) {		
		return pa.getResult(productArray).toString();
	}
}
