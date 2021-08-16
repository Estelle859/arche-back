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

@RestController
@RequestMapping("/api/article")
@CrossOrigin()
public class ArticleController {	

	private final ArticleService articleService;
		
	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}	

	 @GetMapping(path = { "", "/" })
	 public @NotNull List<Article> getArticles() {
		 return articleService.getAllArticles();
	 }
	 
	 @GetMapping(path = "/{id}")
	 public @NotNull Article getArticleById(@PathVariable Integer id) {
		 
		 return articleService.getArticle(id);
	 }
	

}
