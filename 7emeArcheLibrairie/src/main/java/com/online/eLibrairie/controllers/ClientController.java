package com.online.eLibrairie.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.models.User;
import com.online.eLibrairie.services.ClientService;
/**
 * ClientController class is responsible for processing incoming REST API requests related to all types of clients
 * @author Stella
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/client/")
public class ClientController {

	private final ClientService clientService;
	
	/*
	 * this @Autowired injects ArticleService  into  ArticleController
	 *
	 */	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	
	/**
	 * Read - Get one client by his id
	 * @param id -the id of the client
	 * @return a client object full filled
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="{id}")
	public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long id){
		Optional<Client> clientFound = clientService.getClientById(id);
		if(clientFound.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(clientFound);
		}
		else {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	/**
	 * Read - Get all clients
	 * @return a List object of Client full filled
	 */
	@GetMapping(path="all")
	public ResponseEntity<List<Client>> getAllClients(){
		List<Client> clients = clientService.getAllClients();
		if(clients!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(clients);
		}else
		return (ResponseEntity<List<Client>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
	}
	
	 /**
	  * Create - Add a new client
	  * @param user an object Client
	  * @return client object saved
	  */
	 @PostMapping(value="add")
	 public Client addUser  (@RequestBody Client user) {	
		// System.out.println("USER::"+user.getNom());
		
		 return clientService.save(user);
  
	  }	
	 
	/**
	 * Read - Get one client by his name and password
	 * @param nom name of the client
	 * @param motdepasse password of the client
	 * @return
	 */
	@GetMapping(path="{nom}/{motdepasse}")	
	@ResponseBody
	public  Client getClientByNomAndMotdePasse(@PathVariable  String nom,@PathVariable String motdepasse)
	{
		
		return clientService.getClientByNomAndMotdePasse(nom, motdepasse);			
		
	}

}
