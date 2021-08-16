package com.online.eLibrairie.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.models.LignePanier;
import com.online.eLibrairie.models.Panier;
import com.online.eLibrairie.services.ArticleService;
import com.online.eLibrairie.services.LignePanierService;
import com.online.eLibrairie.services.PanierService;

@RestController
@RequestMapping("/api/lignepanier")
@CrossOrigin()
public class LignePanierController {
	
	@Autowired
	private LignePanierService lignePanierService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private PanierService panierService;
	
	 @GetMapping("/all")
	 public List<LignePanier> getLignePaniers() {
		 return lignePanierService.findAllLignePaniers();
	 }
	 
	 @GetMapping("/{id}")
	 public  LignePanier getLignePanierById(@PathVariable Integer id) {		 
		 return lignePanierService.getLignePanierById(id);
	 }

//	 
//	 @PostMapping("/{productid}")
//	 public LignePanier addCartItemLignePanier (@PathVariable Integer productid) {	
//		 Article cartItem =articleService.getArticle(productid);
//		 Panier cart = new Panier();
//		 cart.setId(productid);
//		 LignePanier lignePanier = new LignePanier();
//		 lignePanier.setPanier(cart);
//		 lignePanier.setArticle(cartItem);
//		 lignePanier.setQuantitePanier(1);
//		 lignePanier.setPrixUnitaire(cartItem.getPrixUnitaire());
//		 Date date = new Date();
//		 lignePanier.setDateAdded(date);
//		 return lignePanierService.save(lignePanier);
//  
//	  }
//	 
//	 @PostMapping(value="/add")
//	 public ResponseEntity<Integer> addcartItem (@RequestBody Panier panier,@RequestParam(name="articleId") Integer articleId) {	
//		 Article cartItem =articleService.getArticle(articleIid);
//		 Panier cart = new Panier();
//		 cart.setId(productid);
//		 LignePanier lignePanier = new LignePanier();
//		 lignePanier.setPanier(cart);
//		 lignePanier.setArticle(cartItem);
//		 lignePanier.setQuantitePanier(1);
//		 lignePanier.setPrixUnitaire(cartItem.getPrixUnitaire());
//		 Date date = new Date();
//		 lignePanier.setDateAdded(date);
//		 return lignePanierService.save(lignePanier);
//  
//	  }
	
	 
	 

}
