package com.online.eLibrairie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.models.Livre;
import com.online.eLibrairie.repositories.LivreRepository;
/**
 * This LivreService Class is used to write business logic for Livre model to store, retrieve, update and delete the livre.
 * @author stella
 *
 */
@Service
public class LivreService {
	
	private final LivreRepository livreRepository;
	
	/**
	 * this constructor for an instance of LivreRepository
	 * @param livreRepository
	 */
	@Autowired
	public LivreService(LivreRepository livreRepository) {
		this.livreRepository = livreRepository;
	}
	
	/**
	 * find a livre by its id
	 * @param id of a livre
	 * @return Livre found
	 */
	public Optional<Livre> getLivreById(Long id){
		return this.livreRepository.findById(id);
	}
	
	/**
	 * retrieves a list of livres from livre table of the database
	 * @return a list of livres
	 */
	public List<Livre> getAllLivres(){
		return this.livreRepository.findAll();
	}
}
