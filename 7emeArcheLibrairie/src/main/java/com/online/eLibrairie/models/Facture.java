package com.online.eLibrairie.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table (name="facture")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date dateFacture;
    private String libelle;  
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "commande_id", referencedColumnName = "id")
	 private Commande commande;

}
