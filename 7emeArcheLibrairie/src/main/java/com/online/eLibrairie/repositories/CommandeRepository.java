package com.online.eLibrairie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.online.eLibrairie.models.Commande;

/**
* Interface for generic CRUD operations on a repository for Commande
* we can  implement certain methods for manageing our commandes 
* like findAll(),findById(),save()
*/
public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
