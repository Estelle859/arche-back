package com.online.eLibrairie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.online.eLibrairie.models.LigneCommande;
/**
 * Interface for generic CRUD operations on a repository forLigeCommande
 * @author stella
 *
 */
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long>{


}
