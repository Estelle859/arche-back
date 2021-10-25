package com.online.eLibrairie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.online.eLibrairie.models.Article;

/**
 * Interface for generic CRUD operations on a repository for Article
 * we can implement certain methods for managing our Article
 * like findAll(),findById(),save()
 * @author stella
 *
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
	

}
