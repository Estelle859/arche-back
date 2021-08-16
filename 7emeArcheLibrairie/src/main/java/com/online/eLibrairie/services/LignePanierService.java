package com.online.eLibrairie.services;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.models.LignePanier;
import com.online.eLibrairie.repositories.LignePanierRepository;


@Service
public class LignePanierService {

	private final LignePanierRepository lignePanierRepository;
	
	@Autowired
	public LignePanierService(LignePanierRepository lignePanierRepository) {
		this.lignePanierRepository = lignePanierRepository;
	}

	 public LignePanier save(LignePanier lignePanier) {
	        return this.lignePanierRepository.save(lignePanier);
	    }
	    
		public List<LignePanier> findAllLignePaniers() {		
			return this.lignePanierRepository.findAll();
		}
//		void deleteByLignePanierIdAndClient(Integer id, String client) {
//			this.lignePanierRepository.deleteById(id,client);
//		}
	    public LignePanier getLignePanierById(Integer id) {
	        return this.lignePanierRepository.getOne(id);
	    }
	 



	
}
