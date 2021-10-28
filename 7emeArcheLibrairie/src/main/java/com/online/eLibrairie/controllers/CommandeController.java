package com.online.eLibrairie.controllers;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.models.Commande;
import com.online.eLibrairie.models.LigneCommande;
import com.online.eLibrairie.services.ArticleService;
import com.online.eLibrairie.services.ClientService;
import com.online.eLibrairie.services.CommandeService;
import com.online.eLibrairie.services.LigneCommandeService;

/**
 * this CommandeController class is responsible for processing incoming REST API
 * requests related to the orders(commande) made by clients
 * 
 */

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/commande/")
@RestController
public class CommandeController {
	/*
	 * @Autowired injects ArticleService into this CommandeController
	 *
	 */
	@Autowired
	private ArticleService articleService;
	/*
	 * @Autowired injects ClientService into this CommandeController
	 *
	 */
	@Autowired
	private ClientService clientService;

	/*
	 * @Autowired injects CommandeService into this CommandeController
	 *
	 */
	@Autowired
	private CommandeService commandeService;
	/*
	 * @Autowired injects LigneCommandeService into this CommandeController
	 *
	 */
	@Autowired
	private LigneCommandeService ligneCommandeService;

	/**
	 * Read - Get all orders(commandes)
	 * 
	 * @return a Iterable object of Commande full filled whis not to be null
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public @NotNull Iterable<Commande> list() {
		return this.commandeService.getAllCommandes();
	}

	/**
	 * Read - Get one order(commande) by its id
	 * 
	 * @param id of the order(commande)
	 * @return Commande object full filled
	 */


	@GetMapping(path = "{id}")
	public @NotNull Commande getCommande(@PathVariable Long id) {
		System.out.println(commandeService.getCommande(id));
		return commandeService.getCommande(id);
	}

	/**
	 * Create - Add a new order
	 * 
	 * @param orderForm - An object Commande
	 * @return Commande object saved
	 */

	@PostMapping(value = "add")
	/*
	 * @PostMapping gére les requête HTTP POST correspondant l' url /api/commande/
	 */
	public Commande saveOrder(@Valid @RequestBody Commande commande) {
		commande.setDateCommande(new Date());		
		return commandeService.save(commande);
	}
//    private void validateProductsExistence(List<OrderProduct> orderProducts) {
//        List<OrderProduct> list = orderProducts
//          .stream()
//          .filter(op -> Objects.isNull(articleService.getArticle(op          
//            .getId())))
//          .collect(Collectors.toList());
//
//        if (!CollectionUtils.isEmpty(list)) {
//            new ResourceNotFoundException("Article not found");
//        }
//    }

}
