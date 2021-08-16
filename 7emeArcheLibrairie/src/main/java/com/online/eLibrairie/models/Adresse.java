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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name="adresse")
public class Adresse  {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	 

	private String rue;		 

	private String codePostale;	

	private String ville;	
	
	
	  @ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,
	  CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})	  
	  @JoinTable( name="client_adresse", joinColumns=@JoinColumn(name="adresse_id",
	  referencedColumnName = "id"),
	  inverseJoinColumns=@JoinColumn(name="client_id", referencedColumnName = "id")	  
	  ) 
	  @JsonIgnore
	  private List<Client> clients;
	 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}	
	  public List<Client> getClients() { return clients; } 
	  public void setClients(List<Client> clients) { this.clients = clients; }
	 
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", rue=" + rue + ", codePostale=" + codePostale + ", ville=" + ville + "]";
	}	
	
	

}
