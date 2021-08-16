package com.online.eLibrairie.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.online.eLibrairie.services.ClientService;
import com.online.eLibrairie.services.PanierService;

@RestController
@RequestMapping("/api/panier")
@CrossOrigin()
public class PanierController {
	@Autowired
	private PanierService panierService;

	 @GetMapping()
	 public List<Panier> getPaniers() {
		 return panierService.findAllPaniers();
	 }
	 
	 @GetMapping("/{id}")
	 public  Optional<Panier> getPanierById(@PathVariable Integer id) {		 
		 return panierService.getPanierById(id);
	 }
	 
	 @PostMapping(value="/add")
	 public Panier addCartItem  (@RequestBody Panier panier) {		
		 return panierService.create(panier);
  
	  }
	
	
	

}
