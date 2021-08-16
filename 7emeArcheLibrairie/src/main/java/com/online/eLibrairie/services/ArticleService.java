package com.online.eLibrairie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.repositories.ArticleRepository;
import com.online.eLibrairie.exceptions.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ArticleService{
	
	private final ArticleRepository articleRepository;
	
	@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        return articleRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
    }

    public Article save(Article article) {
        return articleRepository.save(article);
    }
    
    public void remove(Integer id) {
    	articleRepository.deleteById(id);
    }
    

}
