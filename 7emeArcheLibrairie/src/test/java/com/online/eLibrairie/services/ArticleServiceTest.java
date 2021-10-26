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

import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.repositories.ArticleRepository;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class ArticleServiceTest {
	@InjectMocks
	
	private ArticleService articleService;
	
	@Mock
	private ArticleRepository articleRepository;
	

	@Test
	public void shouldReturnArticle() throws Exception {
    	
    	List<Article> articles = new ArrayList<>();
    	Article article = new Article();
    	article.setId(1L);
    	article.setPrixUnitaire(100);
    	article.setQuantiteEnStock(10);
    	articles.add(article);

    	Mockito.when(articleRepository.findAll()).thenReturn(articles);
    	List<Article> articlesFound = articleService.getAllArticles();
    	Assert.assertEquals(articlesFound, articles);    
    	   
         
    	
	}
}
