package com.online.eLibrairie.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.online.eLibrairie.models.Livre;


public interface LivreRepository extends JpaRepository<Livre, Integer> {
	
}
