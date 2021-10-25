package com.online.eLibrairie.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.models.Livre;

/**
 * Interface for generic CRUD operations on a repository for Livre
 * @author stella
 *
 */
public interface LivreRepository extends JpaRepository<Livre, Long> {
	
}
