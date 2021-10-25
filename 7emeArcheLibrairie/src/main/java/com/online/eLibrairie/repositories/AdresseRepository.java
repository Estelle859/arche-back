package com.online.eLibrairie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.online.eLibrairie.models.Adresse;
/**
 * Interface for generic CRUD operations on a repository for user's adresse
 * we can implement certain methods for managing adresse of the user
 * like findAll(),findById(),save()
 * @author stella
 *
 */
public interface AdresseRepository extends JpaRepository<Adresse, Long>{
	

}
