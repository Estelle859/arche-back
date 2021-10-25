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

import com.online.eLibrairie.models.Livre;
import com.online.eLibrairie.services.LivreService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class LivreControllerTest {

	@Autowired
    private MockMvc mvc;

    @MockBean
    private LivreService livreService;

    private List<Livre> artList;

    @Before
    public void init() {
    	LivreControllerTest testClass;
		MockitoAnnotations.initMocks(this);
    }

	@Test
	void testGetLivreById() {
		
	}

	@Test
	void testGetAllLivres() throws Exception {
		List<Livre> livres = new ArrayList<>();
    	Livre livre = new Livre();
    	livre.setId(1L);
    	livre.setPrixUnitaire(100);
    	livre.setQuantiteEnStock(10);
    	livres.add(livre);

    	   Mockito.when(livreService.getAllLivres()).thenReturn(livres);
    	    
    	    mvc.perform(MockMvcRequestBuilders
    	            .get("/api/livre/all")
    	            .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
    	            .andExpect(status().isOk())
    	            .andExpect(content().contentType("application/json"));
         	
	}

}
