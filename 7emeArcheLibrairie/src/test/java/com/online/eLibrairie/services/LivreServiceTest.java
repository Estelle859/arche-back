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

import com.online.eLibrairie.models.Genre;
import com.online.eLibrairie.models.Livre;
import com.online.eLibrairie.repositories.LivreRepository;


@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class LivreServiceTest {

	@InjectMocks
	private LivreService livreService;
	
	@Mock
	private LivreRepository livreRepository;
	

	@Test
	void testGetLivreById() {
		
	}

	@Test
	void testGetAllLivres() {
		List<Livre> livres = new ArrayList<>();
    	Livre livre = new Livre();
    	livre.setId(1L);
    	livre.setPrixUnitaire(10);
    	livre.setFormat("Broché");
    	
    	livres.add(livre);

    	Mockito.when(livreRepository.findAll()).thenReturn(livres);
    	List<Livre> livresFound = livreService.getAllLivres();
    	Assert.assertEquals(livresFound, livres); 
	}

}
