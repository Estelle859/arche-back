package com.online.eLibrairie.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.repositories.ClientRepository;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class ClientServiceTest {

	@InjectMocks
	private ClientService clientService;
	
	@Mock
	private ClientRepository clientRepository;
	

	@Test
	void testGetClientById() {
		
	}

	@Test
	void testGetAllClients() {
		List<Client> clients = new ArrayList<>();
    	Client client = new Client();
    	client.setId(1L);
    	client.setNom("nom");
    	client.setPrenom("prenom");
    	client.setMotdepasse("******");
    	client.setEmail("email@email.com");
    	client.setTelephone("0000000000");
    	clients.add(client);

    	Mockito.when(clientRepository.findAll()).thenReturn(clients);
    	List<Client> clientsFound = clientService.getAllClients();
    	Assert.assertEquals(clientsFound, clients);    
	}

	@Test
	void testSave() {
		
	}

	@Test
	void testGetClientByNomAndMotdePasse() {
		
	}

}
