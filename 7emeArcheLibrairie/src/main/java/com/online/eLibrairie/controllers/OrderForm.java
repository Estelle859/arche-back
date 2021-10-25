package com.online.eLibrairie.controllers;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.models.LigneCommande;

/**
 * this class OrderFor used as a form of an order(commande) avec list of product items ordered (lignecommandes)
 * @author stella
 *
 */
/*
 * @Data generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects) and beans:
 * getters for all fields, setters for all non-final fields, 
 * and appropriate toString, equals and hashCode implementations that involve the fields of the class, 
 * and a constructor that initializes all final fields, as well as all non-final fields with no initializer that have been marked with @NonNull, 
 * in order to ensure the field is never null.
 */
@Data
public class OrderForm {
	  private Client client=new Client();
	  private Double prixTotal = null;	
	  private List<OrderProduct> products=new ArrayList<>();
	  
}
@Data
class OrderProduct{
	private Long id;
	private Integer qte;
//private Article article;
//private float prixUnitaire;
    

}
