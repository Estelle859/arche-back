package com.online.eLibrairie.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.services.ArticleService;

/**
 * ArticleController class is responsible for processing incoming REST API requests related to the article
 * @author stella
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/article")
public class ArticleController {	

	private final ArticleService articleService;
		
	
	/*
	 * this @Autowired injects ArticleService  into  ArticleController
	 *
	 */
	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	/**
	 * Read - Get all clients
	 * @return List object of Article full filled, not to be null
	 */
	 @GetMapping(path = { "", "/" })
	 public @NotNull List<Article> getArticles() {
		 return articleService.getAllArticles();
	 }
	 
	 /**
	  * Read - Get one article by its id
	  * @param id of the article
	  * @return an article object full filled
	  */
	 @GetMapping(path = "/{id}")
	 public @NotNull Article getArticleById(@PathVariable Long id) {
		 
		 return articleService.getArticle(id);
	 }
	

}
