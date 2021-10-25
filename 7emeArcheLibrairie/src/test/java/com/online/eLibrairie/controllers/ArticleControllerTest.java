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

import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.services.ArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ArticleControllerTest {

	@Autowired
    private MockMvc mvc;

    @MockBean
    private ArticleService articleService;

    private List<Article> artList;

    @Before
    public void init() {
    	ArticleControllerTest testClass;
		MockitoAnnotations.initMocks(this);
    }

	@Test
	void testArticleController() {
		
	}

	@Test
	void testGetArticles() throws Exception {
		List<Article> articles = new ArrayList<>();
    	Article article = new Article();
    	article.setId(1L);
    	article.setPrixUnitaire(100);
    	article.setQuantiteEnStock(10);
    	articles.add(article);

    	   Mockito.when(articleService.getAllArticles()).thenReturn(articles);
    	    
    	    mvc.perform(MockMvcRequestBuilders
    	            .get("/api/article")
    	            .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
    	            .andExpect(status().isOk())
    	            .andExpect(content().contentType("application/json"));
         
    	
	}
	

	@Test
	void testGetArticleById() {
		
	}

}
