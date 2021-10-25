package com.online.eLibrairie.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * this model classe Commande represents a Commande entity
 * 
 * @author stella 
 * @version 1.0
 * @since 1.0
 */
/*
 * @Entity annotation specifies that the class is a command entity and is mapped to the database command table
 * @Table annotation specifies the name of the database table is command which is used for mapping.
 * @Data generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects) and beans:
 * getters for all fields, setters for all non-final fields, 
 * and appropriate toString, equals and hashCode implementations that involve the fields of the class, 
 * and a constructor that initializes all final fields, as well as all non-final fields with no initializer that have been marked with @NonNull, 
 * in order to ensure the field is never null.
 */

@Entity
@Table (name="commande")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="ligneCommandes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Commande {
	/*
	 * @Id annotation specifies the primary key of the Command and 
	 * @GeneratedValue gives the generation strategy for primary key values.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	    
	@Column(name="date_commande")
    @JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateCommande;	

   	@Column(name="prix_total")	
	private Double prixTotal;	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="client_id", referencedColumnName = "id", insertable = false, updatable = false) 	
	@JsonIgnore
	private Client client;
	

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes = new ArrayList<>();


}

