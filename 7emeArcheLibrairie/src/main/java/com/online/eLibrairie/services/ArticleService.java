package com.online.eLibrairie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.repositories.ArticleRepository;
import com.online.eLibrairie.exceptions.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * This Service Class is used to write business logic for Article model to store, retrieve, update and delete the articles.
 * @author stella
 *
 */
@Service
@Transactional
public class ArticleService{
	
	private final ArticleRepository articleRepository;
	
	/**
	 * this constructor is for an instance of ArticleRepository 
	 * @param articleRepository
	 */
	@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	/**
	 * Retrieves all the articles from table article from the database
	 * @return a  List object of Articles found
	 */
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    /**
     * Retrieve an article by its id
     * @param id of an article
     * @return an article found
     */
    public Article getArticle(Long id) {
        return articleRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
    }

	/**
	 * Save one article into the table article of the database
	 * @param article an object Article
	 * @return article of an object saved
	 */
    public Article save(Article article) {
        return articleRepository.save(article);
    }
    
    /**
     * Remove an article from the table article of the database
     * @param id of an article
     */
    public void remove(Long id) {
    	articleRepository.deleteById(id);
    }
    

}
