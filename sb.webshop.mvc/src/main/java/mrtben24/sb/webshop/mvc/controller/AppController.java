package mrtben24.sb.webshop.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mrtben24.sb.webshop.mvc.db.Database;
import mrtben24.sb.webshop.mvc.model.Product;
import mrtben24.sb.webshop.mvc.model.User;

@Controller
public class AppController {

	@GetMapping("/")
	public String showIndex(Model model) {

		Database db = new Database();
		List<Product> products = null;

		products = db.getAllProduct();
		
		db.closeDb();
		
		model.addAttribute("products", products);

		return "index.html";
	}
	
	@GetMapping("/addToBasket")
	public String addToBasket(
			Model model,
			@RequestParam(name="pId") int pId
			) {
		
		showIndex(model);
		
		User user = new User();
		System.out.println(user.getUserProdIdList());
		// hozzá kell adni egy listához a kiválasztott cuccokat
		
		
		
		
		

		return "index.html";
	}
	
	
}
