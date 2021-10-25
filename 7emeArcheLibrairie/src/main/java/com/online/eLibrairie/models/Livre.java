package com.online.eLibrairie.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * this model classe Livre represents an Livre entity, which is sub class that inherits from the base class Article
 * @author Stella
 * @version 1.0
 * @since 1.0
 */

/*
 * @Entity annotation specifies that the class is an Livre entity and is mapped to the database livre table
 * @Table annotation specifies the name of the database table is livre which us used for mapping.
 * @Data generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects) and beans:
 * getters for all fields, setters for all non-final fields, 
 * and appropriate toString, equals and hashCode implementations that involve the fields of the class, 
 * and a constructor that initializes all final fields, as well as all non-final fields with no initializer that have been marked with @NonNull, 
 * in order to ensure the field is never null.
 */

@Entity
@Table (name="livre")
@PrimaryKeyJoinColumn( name = "id" )
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Livre extends Article {
	
	private String titre;		

	private String isbn;	

	private String format;	

	private String image;	

	private String type;	
	
	private String resume;
	
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="livre_auteur",
			joinColumns=@JoinColumn(name="livre_id", referencedColumnName = "id"),
			inverseJoinColumns=@JoinColumn(name="auteur_id", referencedColumnName = "id")
			)
	
	private List<Auteur> auteurs;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="livre_genre",
			joinColumns=@JoinColumn(name="livre_id", referencedColumnName = "id"),
			inverseJoinColumns=@JoinColumn(name="genre_id", referencedColumnName = "id")
			)

	private List<Genre> genres;
	

	
	
		  
}
