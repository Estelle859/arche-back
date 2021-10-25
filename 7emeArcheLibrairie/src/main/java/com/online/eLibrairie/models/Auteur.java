package com.online.eLibrairie.models;

import java.util.List;

import javax.persistence.CascadeType;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * this model classe Auteur represents an Auteur entity
 * @author Stella
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name="auteur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Auteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;	

  	private String prenom;

  	private String email;
	
  	private String telephone;
  	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="livre_auteur",
			joinColumns=@JoinColumn(name="auteur_id", referencedColumnName = "id"),
			inverseJoinColumns=@JoinColumn(name="livre_id", referencedColumnName = "id")
			)
	@JsonIgnore
	private List<Livre> livres;


	

}
