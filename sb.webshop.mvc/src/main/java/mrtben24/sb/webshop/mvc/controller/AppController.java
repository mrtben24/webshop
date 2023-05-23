package mrtben24.sb.webshop.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;

import mrtben24.sb.webshop.mvc.db.Database;

public class AppController {

	@GetMapping("/")
	String showIndex() {
		
		
		
		return "index.html";
	}
}
