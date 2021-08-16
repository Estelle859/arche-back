package com.online.eLibrairie.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table (name="ligne_panier")
public class LignePanier {
	@Id	
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="quantite_panier")
	private Integer quantitePanier;
	
	@Column(name="tva")
	private Integer tva;
	
	@Column(name="prixUnitaire")	
	private float prixUnitaire;	
	
	@Column(name="prix_ttc")	
	private float prixTTC;	 
	
	@Column(name="prix_ht")	
	private float prixHT;
	
	@Column(name="prix_tva")	
	private float prixTVA;
	
	@Column(name = "date_added")
	private Date dateAdded;
	
	 
	@JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)   
    private Panier panier;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;
    

	public LignePanier() {
		super();
		// TODO Auto-generated constructor stub
	}




	public LignePanier(Integer id, Integer quantitePanier, Integer tva, float prixUnitaire, float prixTTC, float prixHT,
			float prixTVA, Date dateAdded, Panier panier, Article article) {
		super();
		this.id = id;
		this.quantitePanier = quantitePanier;
		this.tva = tva;
		this.prixUnitaire = prixUnitaire;
		this.prixTTC = prixTTC;
		this.prixHT = prixHT;
		this.prixTVA = prixTVA;
		this.dateAdded = dateAdded;
		this.panier = panier;
		this.article = article;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getQuantitePanier() {
		return quantitePanier;
	}


	public void setQuantitePanier(Integer quantitePanier) {
		this.quantitePanier = quantitePanier;
	}


	public Integer getTva() {
		return tva;
	}


	public void setTva(Integer tva) {
		this.tva = tva;
	}


	public float getPrixUnitaire() {
		return prixUnitaire;
	}


	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}


	public float getPrixTTC() {
		return prixTTC;
	}


	public void setPrixTTC(float prixTTC) {
		this.prixTTC = prixTTC;
	}


	public float getPrixHT() {
		return prixHT;
	}


	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}


	public float getPrixTVA() {
		return prixTVA;
	}


	public void setPrixTVA(float prixTVA) {
		this.prixTVA = prixTVA;
	}


	public Panier getPanier() {
		return panier;
	}


	public void setPanier(Panier panier) {
		this.panier = panier;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	public Date getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}



    

}
