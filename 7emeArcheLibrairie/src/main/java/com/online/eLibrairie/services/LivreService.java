package com.online.eLibrairie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.models.Livre;
import com.online.eLibrairie.repositories.LivreRepository;

@Service
public class LivreService {
	
	private final LivreRepository livreRepository;
	
	@Autowired
	public LivreService(LivreRepository livreRepository) {
		this.livreRepository = livreRepository;
	}
	
	public Optional<Livre> getLivreById(Integer id){
		return this.livreRepository.findById(id);
	}
	public List<Livre> getAllLivres(){
		return this.livreRepository.findAll();
	}
}
