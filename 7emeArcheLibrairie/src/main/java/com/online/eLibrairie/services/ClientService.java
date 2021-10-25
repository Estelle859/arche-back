package com.online.eLibrairie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.models.User;
import com.online.eLibrairie.repositories.ClientRepository;

/**
 * This ClientService Class is used to write business logic for Client model to store, retrieve, update and delete the clients
 * @author stella
 *
 */
@Service
public class ClientService {
	
	private final ClientRepository clientRepository;
	/**
	 * constructor for an instance of ClientRepository 
	 * @param clientRepository
	 */
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	/**
	 * Retrieve one client by his id
	 * @param id of a client
	 * @return Client found
	 */
	public Optional<Client> getClientById(Long id){
		return this.clientRepository.findById(id);
	}
	
	/**
	 * Retrieves all the clients from the client table of the database
	 * @return list of all clients 
	 */
	public List<Client> getAllClients(){
		return this.clientRepository.findAll();
	}
	
	/**
	 * Save one client into the table of client of the database.
	 * @param client   - of an object Client
	 * @return client of an object saved 
	 */
	 public Client save(Client  client) {
	        return clientRepository.save(client);
	    }
	 
	 /**
	  * Retrieve a client by his name and password 
	  * @param nom - name of the client
	  * @param motdepasse - assword of the client
	  * @return
	  */
	 public Client getClientByNomAndMotdePasse(String nom, String motdepasse) {
	        return 	clientRepository.findByNomAndMotdepasse(nom, motdepasse);
	        		
	    }
}
