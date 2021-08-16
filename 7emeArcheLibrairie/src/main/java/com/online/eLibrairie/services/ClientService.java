package com.online.eLibrairie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.repositories.ClientRepository;
import java.util.Optional;
import java.util.List;
@Service
public class ClientService {
	
	private final ClientRepository clientRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public Optional<Client> getClientById(Integer id) {return this.clientRepository.findById(id);}
	
	
	public List<Client> getAllClients() {		
		return this.clientRepository.findAll();
	}
	
}
