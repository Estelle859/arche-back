package com.online.eLibrairie.models;


import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Table (name="article")
@Inheritance( strategy = InheritanceType.JOINED)
public class Article {
	
	@Id	
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
		
	private String resume;
	
	private Integer quantiteEnStock;
	
	private float prixUnitaire;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantiteEnStock() {
		return quantiteEnStock;
	}
	public void setQuantiteEnStock(Integer quantiteEnStock) {
		this.quantiteEnStock = quantiteEnStock;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", resume=" + resume + ", quantiteEnStock=" + quantiteEnStock + ", prixUnitaire="
				+ prixUnitaire + "]";
	}	
	
	
	

}
