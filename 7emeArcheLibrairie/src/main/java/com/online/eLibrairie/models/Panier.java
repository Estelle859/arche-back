package com.online.eLibrairie.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Panier {
	@Id	
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    
	@Column(name="date_mvt")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateMvt;	

	@Column(name="total_ttc")	
	private Double prixTTC;	 
	
	@Column(name="total_ht")	
	private Double prixHT;
	
	@Column(name="total_tva")	
	private Double prixTVA;
	
//	@ManyToOne()
//	@JoinColumn(name="client_id", referencedColumnName = "id", insertable = false, updatable = false) 	
//	@JsonIgnore
//	private Client client;
	
	
	@JsonManagedReference
    @OneToMany(mappedBy = "panier")
	@Valid
    private List<LignePanier> lignePaniers = new ArrayList<>();


	public LocalDate getDateMvt() {
		return dateMvt;
	}


	public void setDateMvt(LocalDate dateMvt) {
		this.dateMvt = dateMvt;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Double getPrixTVA() {
		return prixTVA;
	}


	public void setPrixTVA(Double prixTVA) {
		this.prixTVA = prixTVA;
	}


//	public Client getClient() {
//		return client;
//	}
//
//
//	public void setClient(Client client) {
//		this.client = client;
//	}


	public List<LignePanier> getLignePaniers() {
		return lignePaniers;
	}


	public void setLignePaniers(List<LignePanier> lignePaniers) {
		this.lignePaniers = lignePaniers;
	}


	


	
	

}
