package com.online.eLibrairie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.exceptions.ResourceNotFoundException;
import com.online.eLibrairie.models.Commande;
import com.online.eLibrairie.repositories.CommandeRepository;
/**
 * This CommandeService Class is used to write business logic for Commande model to store, retrieve, update and delete the commandes.
 * @author stella
 *
 */
@Service
public class CommandeService {
	
	private final CommandeRepository commandeRepository;
	/*
	* this @Autowired injects CommandeRepository into CommandeService 
	*
	*/		
	@Autowired
	public CommandeService(CommandeRepository commandeRepository) {
		this.commandeRepository = commandeRepository;
	}
	
	/**
	 * This method for retrieving all the commands
	 * @return list of commandes
	 */
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    /**
     * this method for retrieving one commande by his id
     * @param id - id of the commande
     * @return commande found
     */
    public Commande getCommande(Long id) {
        return commandeRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Commande not found"));
    }    
   
	/**
	 * this method for adding commande into the commande table of the database
	 *  @param commande
	 *  @return commande of the object commande saved    
	 */  
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }
    
   /**
    * this method is for deleting one commande from commande table    
    * @param id - id of a commande
    */
    public void remove(Long id) {
    	commandeRepository.deleteById(id);
    }

}
