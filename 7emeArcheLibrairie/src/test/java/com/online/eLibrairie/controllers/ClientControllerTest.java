package com.online.eLibrairie.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.services.ClientService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

	@Autowired
    private MockMvc mvc;

    @MockBean
    private ClientService clientService;

    private List<Client> clientList;

    @Before
    public void init() {
    	ClientControllerTest testClass;
		MockitoAnnotations.initMocks(this);
    }

	@Test
	void testGetClientById() {
		
	}

	@Test
	void testGetAllClients() throws Exception {
		List<Client> clients = new ArrayList<>();
    	Client client = new Client();
    	client.setId(1L);
    	client.setNom("nom");
    	client.setPrenom("prenom");
    	client.setMotdepasse("******");
    	client.setEmail("email@email.com");
    	client.setTelephone("0000000000");
    	clients.add(client);

    	   Mockito.when(clientService.getAllClients()).thenReturn(clients);
    	    
    	    mvc.perform(MockMvcRequestBuilders
    	            .get("/api/client/all")
    	            .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
    	            .andExpect(status().isOk())
    	            .andExpect(content().contentType("application/json"));
	}

	@Test
	void testAddUser() {
		
	}

	@Test
	void testGetClientByNomAndMotdePasse()  {
		
         
	}

}
