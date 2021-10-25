package com.online.eLibrairie.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
/**
 * this model classe Article represents an Article entity, which is base class for all the types of articles including livre
 * @author Stella
 * @version 1.0
 * @since 1.0
 */

/*
 * @Entity annotation specifies that the class is an Article entity and is mapped to the database article table
 * @Table annotation specifies the name of the database table is article which us used for mapping.
 * @Data generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects) and beans:
 * getters for all fields, setters for all non-final fields, 
 * and appropriate toString, equals and hashCode implementations that involve the fields of the class, 
 * and a constructor that initializes all final fields, as well as all non-final fields with no initializer that have been marked with @NonNull, 
 * in order to ensure the field is never null.
 */
@Entity
@Table (name="article")
@Inheritance( strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {
	/*
	 * @Id annotation specifies the primary key of the article and 
	 * @GeneratedValue gives the generation strategy for primary key values.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	private Integer quantiteEnStock;
	
	private float prixUnitaire;
	
	
}
