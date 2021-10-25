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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * this model classe Client represents a Client entity is a sub class that inherits from the base class User
 * @author Stella
 * @version 1.0
 * @since 1.0
 */
/*
 * @Entity annotation specifies that the class is a client entity and is mapped to the database client table
 * @Table annotation specifies the name of the database table is client which is used for mapping.
 * @Data generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects) and beans:
 * getters for all fields, setters for all non-final fields, 
 * and appropriate toString, equals and hashCode implementations that involve the fields of the class, 
 * and a constructor that initializes all final fields, as well as all non-final fields with no initializer that have been marked with @NonNull, 
 * in order to ensure the field is never null.
 */
@Entity
@Table (name="clients")
@PrimaryKeyJoinColumn( name = "id" )
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client  extends User {	
	 
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="clients_adresses",
			joinColumns=@JoinColumn(name="client_id", referencedColumnName = "id"),
			inverseJoinColumns=@JoinColumn(name="adresse_id", referencedColumnName = "id")
			)
	
	private List<Adresse> adresses;
	
}
