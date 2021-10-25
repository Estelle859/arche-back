package com.online.eLibrairie.models;

import java.io.Serializable;
import java.util.Date;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/** 
 * Represents client's address  
 * 
 * @author Stella
 * @version 1.0
 * @since 1.0
 * 
*/

/*
 * @Entity annotation specifies that the class is an Adresse entity and is mapped to the database adresse table
 * @Table annotation specifies the name of the database table is adresse which us used for mapping.
 * @Data generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects) and beans:
 * getters for all fields, setters for all non-final fields, 
 * and appropriate toString, equals and hashCode implementations that involve the fields of the class, 
 * and a constructor that initializes all final fields, as well as all non-final fields with no initializer that have been marked with @NonNull, 
 * in order to ensure the field is never null.
 */
@Entity
@Table (name="adresse")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Adresse  {	
	/*
	 * @Id annotation specifies the primary key of the adresse and 
	 * @GeneratedValue gives the generation strategy for primary key values.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	 

	private String rue;		 

	private String codePostale;	

	private String ville;		
	
 	  
	@ManyToMany(fetch=FetchType.LAZY,
				cascade= {CascadeType.PERSIST, CascadeType.MERGE,
				 CascadeType.DETACH, CascadeType.REFRESH})
		@JoinTable(
				name="clients_adresses",
				joinColumns=@JoinColumn(name="adresse_id", referencedColumnName = "id"),
				inverseJoinColumns=@JoinColumn(name="client_id", referencedColumnName = "id")
				)
		@JsonIgnore
		private List<Client>  clients;
	  
}
