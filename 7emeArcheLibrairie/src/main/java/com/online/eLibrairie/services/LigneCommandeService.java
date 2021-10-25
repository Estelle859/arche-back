package com.online.eLibrairie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.exceptions.ResourceNotFoundException;
import com.online.eLibrairie.models.LigneCommande;
import com.online.eLibrairie.repositories.LigneCommandeRepository;
/**
 * This LigneCommandeService Class is used to write business logic for LigneCommande model to store, retrieve, update and delete the lignecommandes
 * @author stella
 *
 */

@Service
public class LigneCommandeService {
	private final LigneCommandeRepository ligneCommandeRepository;
   /*
	* this @Autowired injects LigneCommandeRepository into this LigneCommandeService 
	*
	*/	
	@Autowired
	public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository) {
		this.ligneCommandeRepository = ligneCommandeRepository;
	}
	
	/**
	 * this method for retrieving all the lignecommands
	 * @return list of items (lignecommandes) for a order(commande)
	 */
    public List<LigneCommande> getAllLigneCommandes() {
        return ligneCommandeRepository.findAll();
    }
    /**
     * this method for retrieving one lignecommande by its id
     * @param id - id of ligneCommande
     * @return LigneCommande found
     */
    public LigneCommande getLigneCommande(Long id) {
        return ligneCommandeRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("LigneCommande not found"));
    }
    
    /**
     * this method for adding lignecommande into the lignecommande table of the database
     * @param ligneCommande - of an object LigneCommande
     * @return LigneCommande of the object ligneCommande saved
     */
    public LigneCommande save(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }
    
    /**
     * this method is for removing one lignecommande from lignecommande table
     * @param id of ligneCommande
     */
    public void remove(Long id) {
    	ligneCommandeRepository.deleteById(id);
    }

}
