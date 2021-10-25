package com.online.eLibrairie.controllers;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.online.eLibrairie.exceptions.ResourceNotFoundException;
import com.online.eLibrairie.models.Adresse;
import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.models.Commande;
import com.online.eLibrairie.models.LigneCommande;
import com.online.eLibrairie.models.User;
import com.online.eLibrairie.repositories.AdresseRepository;
import com.online.eLibrairie.repositories.ArticleRepository;
import com.online.eLibrairie.repositories.ClientRepository;
import com.online.eLibrairie.repositories.CommandeRepository;
import com.online.eLibrairie.repositories.LigneCommandeRepository;
import com.online.eLibrairie.services.ArticleService;
import com.online.eLibrairie.services.ClientService;
import com.online.eLibrairie.services.CommandeService;
import com.online.eLibrairie.services.LigneCommandeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * this CommandeController class is responsible for processing incoming REST API requests related to the orders(commande) made by clients
 * 
 */

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/commande/")
@RestController
public class CommandeController {
	/*
     * @Autowired injects ArticleService into  this CommandeController
     *
     */
	@Autowired
    private ArticleService articleService;
	/*
     * @Autowired injects ClientService into this  CommandeController
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
	*  @Autowired injects LigneCommandeService into this  CommandeController
	*
	*/
    @Autowired
    private LigneCommandeService ligneCommandeService;
    
  
    /**
     * Read - Get all orders(commandes)
     * @return a  Iterable object of Commande full filled whis not to be null
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Commande> list() {
        return this.commandeService.getAllCommandes();
    }
	 
	/**
	 * Read - Get one order(commande) by its id
	 * @param id of the order(commande)
	 * @return Commande object full filled
	 */
    
	 @GetMapping(path="{id}")
	 public @NotNull Commande getCommande(@PathVariable Long id) {		 
		 return commandeService.getCommande(id);
	 }	 
	 
	 /**
	  * Create - Add a new order
	  * @param orderForm - An object Commande
	  * @return Commande object saved
	  */
	
    @PostMapping(value="add")
     /*
	  * 	 @PostMapping gére les requête HTTP POST correspondant l' url	/api/commande/
	  */
    public Commande saveOrder(@Valid @RequestBody OrderForm orderForm){
    	List<OrderProduct> form = orderForm.getProducts();
    	System.out.println("Client" +orderForm.getClient()+orderForm.getPrixTotal());    
    	System.out.println("PRODUCTS" +form);    	
        Client client=new Client();
        client.setId(orderForm.getClient().getId());
        client.setNom(orderForm.getClient().getNom());
        client.setPrenom(orderForm.getClient().getPrenom());
        client.setEmail(orderForm.getClient().getEmail());
      //  client.setAdresses(orderForm.getClient().getAdresses());
        client.setTelephone(orderForm.getClient().getTelephone());        
        client=clientService.save(client);        
        System.out.println("CLI::"+client.getNom());
        Commande commande=new Commande();
        commande.setClient(client);
        System.out.println("CLIFROMCOMMANDE::"+commande.getClient().getNom());
        commande.setDateCommande(new Date());
        commande.setPrixTotal(orderForm.getPrixTotal());
        commande=commandeService.save(commande);       
        System.out.println("ORDERFORM::"+orderForm.getProducts().size());
        double total=0;
        for(OrderProduct p:orderForm.getProducts()){
        	LigneCommande ligneCommande=new LigneCommande();
            ligneCommande.setCommande(commande);
            Article product=articleService.getArticle(p.getId());
            ligneCommande.setArticle(product);
            ligneCommande.setPrixUnitaire(product.getPrixUnitaire());
            ligneCommande.setQuantiteCommande(p.getQte());
            ligneCommandeService.save(ligneCommande);
            total+=p.getQte()*product.getPrixUnitaire();
            System.out.println("TOTAL" + total);
        }
      //  commande.setPrixTotal(total);
        System.out.println(commande.getDateCommande());
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
