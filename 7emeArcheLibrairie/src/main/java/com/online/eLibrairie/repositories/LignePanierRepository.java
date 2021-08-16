package com.online.eLibrairie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.models.LignePanier;

public interface LignePanierRepository extends JpaRepository<LignePanier, Integer>{


}
