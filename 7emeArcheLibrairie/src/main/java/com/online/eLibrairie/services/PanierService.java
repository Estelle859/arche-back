package com.online.eLibrairie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.models.LignePanier;
import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.models.Panier;
import com.online.eLibrairie.repositories.ClientRepository;
import com.online.eLibrairie.repositories.LignePanierRepository;
import com.online.eLibrairie.repositories.PanierRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PanierService {
	


	@Autowired
	PanierRepository panierRepository;
	@Autowired
	LignePanierRepository lignePanierRepository;
	@Autowired
	ClientRepository clientRepository;

	public Optional<Panier> getPanierById(Integer id) {
		return this.panierRepository.findById(id);
	}
	
	public List<Panier> findAllPaniers() {		
		return this.panierRepository.findAll();
	}
	
	public Panier create(Panier panier) {
		List<LignePanier> lPaniers = panier.getLignePaniers();
		for(LignePanier lPanier : lPaniers ) {
			lPanier.setId(panier.getId());
			lignePanierRepository.save(lPanier);			
		}
		
		panier.setDateMvt(LocalDate.now());
	    return this.panierRepository.save(panier);
	}
	  
	public void update(Panier panier) {
		this.panierRepository.save(panier);
	}
	public void delete(Integer id) {
		this.panierRepository.deleteById(id);
	}

   
}
