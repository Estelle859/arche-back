package com.online.eLibrairie.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.eLibrairie.models.Adresse;
import com.online.eLibrairie.services.AdresseService;
/**
 * AdresseController class is responsible for processing incoming REST API requests related to the address
 * @author stella
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/adresse")
public class AdresseController {
	private final AdresseService adresseService;
	
	/**
	 * this constructor is used for AdresseService instance
	 * @param adresseService
	 */
	@Autowired	
	public AdresseController(AdresseService adresseService) {
		this.adresseService = adresseService;
	}
	/**
	 * Read - Get one adresse by its id
	 * @param id the id of the adresse
	 * @return an adresse object full filled
	 */
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Adresse>> getLivreById(@PathVariable Long id){
		Optional<Adresse> adresseFound = adresseService.getAdresseById(id);
		if(adresseFound.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(adresseFound);
		}
		else {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	/**
	 * Read - Get all addresses
	 * @return a List object of Adresses full filled
	 */
	@GetMapping(path="/all")
	public ResponseEntity<List<Adresse>> getAllLivres(){
		List<Adresse> adresses = adresseService.getAllAdresses();
		if(adresses!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(adresses);
		}else
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	

}
