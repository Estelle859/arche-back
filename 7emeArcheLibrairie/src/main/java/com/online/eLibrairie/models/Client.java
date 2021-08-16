package com.online.eLibrairie.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table (name="clients")
@PrimaryKeyJoinColumn( name = "id" )
public class Client  extends Utilisateur {
	
	 
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade= {CascadeType.PERSIST,CascadeType.MERGE, 
					CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable( name="client_adresse", joinColumns=@JoinColumn(name="client_id",referencedColumnName = "id"),
	 inverseJoinColumns=@JoinColumn(name="adresse_id", referencedColumnName = "id") ) 
	@JsonIgnore 
	private List<Adresse> adresses;

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return "Client [adresses=" + adresses + "]";
	}



}
