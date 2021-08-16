package com.online.eLibrairie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.online.eLibrairie.repositories.ClientRepository;
import com.online.eLibrairie.services.ClientService;

import ch.qos.logback.core.net.SyslogOutputStream;

import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.models.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
@CrossOrigin()
public class CientController {
	
	private final ClientService clientService;
	
	//private static final String CLIENT_CONTROLLER ="ClientController";
	
	@Autowired
	public CientController(ClientService clientService) {
			this.clientService = clientService;
		
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Client>> getClientById(@PathVariable Integer id)
	{
		Optional<Client> clientFound = clientService.getClientById(id);

		if(clientFound.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(clientFound);
		}
		else {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		
	}
	
	/*
	 * @GetMapping(path="/{nom}") public ResponseEntity<List<Client>>
	 * getClientByName(@PathVariable String nom) { try { List<Client> clients = new
	 * ArrayList<Client>();
	 * 
	 * if (nom == null) clientService.getAllClients(); else
	 * clientService.getClientByName(nom).forEach(clients::add);
	 * 
	 * if (clients.isEmpty()) { return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 * }
	 * 
	 * return new ResponseEntity<>(clients, HttpStatus.OK); } catch (Exception e) {
	 * return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * }
	 */
	
	  @GetMapping(path="/all")
		public ResponseEntity<List<Client>> getAllClients(){		
	 
	  	List<Client> clients = clientService.getAllClients();
		if(clients!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(clients);
		}else
		return (ResponseEntity<List<Client>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
	  }
}
