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
		//[Product [id=1, name=kenyer, price=2332] legördülő menü feltöltése

		return "index.html";
	}
	
	@GetMapping("/addToBasket")
	public String addToBasket(
			Model model,
			@RequestParam(name="pId") int pId
			) {
		
		showIndex(model);
		Database db = new Database();
		
		User user = db.getUserById(1);
		
		user.addToUserProdIdList(pId);
		
		model.addAttribute("user", user);
		//User [id=1, name=geza, userProdIdList=[1]]
		
		return "index.html";
	}
	
	
}
