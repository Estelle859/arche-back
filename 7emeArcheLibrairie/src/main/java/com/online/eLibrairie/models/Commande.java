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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table (name="commande")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="ligneCommandes")
public class Commande {
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	    
	@Column(name="date_commande")
    @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateCommande;	

   	@Column(name="prix_total")	
	private Double prixTotal;	
	
	@ManyToOne()
	@JoinColumn(name="client_id", referencedColumnName = "id", insertable = false, updatable = false) 	
	@JsonIgnore
	private Client client;
	
	@JsonManagedReference
    @OneToMany(mappedBy = "commande")
	@Valid
    private List<LigneCommande> ligneCommandes = new ArrayList<>();

	@Transient
    public Double getTotalPrice() {
        double sum = 0D;
        List<LigneCommande> lcs = getLigneCommandes();
        for (LigneCommande lc : lcs) {
            sum += lc.getTotalPrix();
        }
        return sum;
    }
	@Transient
    public int getNombreArticleCommande() {
        return this.ligneCommandes.size();
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Double getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}
	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	

		

}

