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

import com.online.eLibrairie.models.Livre;
import com.online.eLibrairie.services.LivreService;

/**
 * LivreController class is responsible for processing incoming REST API requests related to the articles of type Livre(book)
 * @author stella
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/livre")
public class LivreController {
	
	private final LivreService livreService;
	
	@Autowired
	public LivreController(LivreService livreService) {
		this.livreService = livreService;
	}
	/**
	 * Read - Get one livre by its id
	 * @param id of the livre
	 * @return a Livre object full filled
	 */
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Livre>> getLivreById(@PathVariable Long id){
		Optional<Livre> livreFound = livreService.getLivreById(id);
		if(livreFound.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(livreFound);
		}
		else {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	/**
	 * Read - Get all livres
	 * @return list of all livres
	 */
	@GetMapping(path="/all")
	public ResponseEntity<List<Livre>> getAllLivres(){
		List<Livre> livres = livreService.getAllLivres();
		if(livres!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(livres);
		}else
		return (ResponseEntity<List<Livre>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
	}

}
