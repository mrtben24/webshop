package mrtben24.sb.webshop.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;

import mrtben24.sb.webshop.mvc.db.Database;
import mrtben24.sb.webshop.mvc.model.Product;

public class AppController {

	@GetMapping("/")
	String showIndex() {
		
		Database db = new Database();
		Product product = new Product();
		product = db.getAllProduct(1);
		System.out.println("defwef");
		System.out.println(product);
		
		return "index.html";
	}
}
