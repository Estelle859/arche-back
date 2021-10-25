package com.online.eLibrairie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.eLibrairie.models.Livre;
import com.online.eLibrairie.models.Paiement;
/**
 * Interface for generic CRUD operations on a repository for Paiement
 * @author stella
 *
 */
public interface PaiementRepository  extends JpaRepository<Paiement, Long> {

}
