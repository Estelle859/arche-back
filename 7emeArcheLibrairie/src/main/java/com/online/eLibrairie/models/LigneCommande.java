package com.online.eLibrairie.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table (name="ligne_commande")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LigneCommande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="quantite_commande")
	private Integer quantiteCommande;
	
	@Column(name="prixUnitaire")	
	private float prixUnitaire;	

//	@Column(name="prix_ttc")	
//	private Double prixTTC;	 
//	
//	@Column(name="prix_ht")	
//	private Double prixHT;
//	
//	@Column(name="prix_tva")	
//	private float prixTVA;

	
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_id", referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Commande commande;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;

}

