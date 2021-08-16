package com.online.eLibrairie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.models.Adresse;
import com.online.eLibrairie.repositories.AdresseRepository;

@Service
public class AdresseService {
	
	private final AdresseRepository adresseRepository;
	
	@Autowired
	public AdresseService(AdresseRepository adresseRepository) {
		this.adresseRepository = adresseRepository;
	}
	

	public Optional<Adresse> getAdresseById(Integer id){
		return this.adresseRepository.findById(id);

	}
	
	public List<Adresse> getAllAdresses(){
		
		return this.adresseRepository.findAll();
	}

}
