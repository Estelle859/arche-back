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

@Entity
@Table (name="ligne_commande")
public class LigneCommande {
	
	@Id	
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="quantite_commande")
	private Integer quantiteCommande;
	
	@Column(name="prix_ttc")	
	private Double prixTTC;	 
	
	@Column(name="prix_ht")	
	private Double prixHT;

	@JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_id", referencedColumnName = "id")
    private Commande commande;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getQuantiteCommande() {
		return quantiteCommande;
	}

	public void setQuantiteCommande(Integer quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}

	public Double getPrixTTC() {
		return prixTTC;
	}

	public void setPrixTTC(Double prixTTC) {
		this.prixTTC = prixTTC;
	}

	public Double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(Double prixHT) {
		this.prixHT = prixHT;
	}


    @Transient
    public Double getTotalPrix() {
        return (double) (getArticle().getPrixUnitaire() * getQuantiteCommande());
    }
  



}

