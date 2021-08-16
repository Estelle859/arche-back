package com.online.eLibrairie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.online.eLibrairie.models.Article;


public interface ArticleRepository extends JpaRepository<Article, Integer> {
	

}
