package com.lombok.web;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lombok.dao.ProduitRepository;
import com.lombok.entities.Produit;

@Controller
public class ProduitController {
	
	@Autowired
	private ProduitRepository produitRepository; 

	@GetMapping(path="/index")
	public String index() {
		return "index";
	}

	@GetMapping(path="/products")
	public String products(Model model) {
		List<Produit> produits= produitRepository.findAll();
		model.addAttribute("listproduits",produits);
		return "products";
	}

}
