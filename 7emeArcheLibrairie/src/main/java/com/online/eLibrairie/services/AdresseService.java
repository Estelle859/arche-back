package com.online.eLibrairie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.models.Adresse;
import com.online.eLibrairie.repositories.AdresseRepository;
/**
 * This Service Class is used to write business logic for Adresse model to store, retrieve, update and delete the adresse.
 * @author stella
 *
 */
@Service
public class AdresseService {
	
	private final AdresseRepository adresseRepository;
	/**
	 * constructor for an instance of AdresseRepository
	 * @param adresseRepository
	 */
	@Autowired
	public AdresseService(AdresseRepository adresseRepository) {
		this.adresseRepository = adresseRepository;
	}
	

	/**
	 * find an adresse by its id
	 * @param id - of the adresse
	 * @return adresse found
	 */
	public Optional<Adresse> getAdresseById(Long id){
		return this.adresseRepository.findById(id);

	}
	
	/**
	 * Get all adresses from adresse table
	 * @return list of all adresses
	 */
	public List<Adresse> getAllAdresses(){
		
		return this.adresseRepository.findAll();
	}

}
