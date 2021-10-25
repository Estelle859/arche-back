package com.online.eLibrairie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.models.User;
/**
 * Interface for generic CRUD operations on a repository for Client
 * we can implement certain methods for managing our Client's data
 * like findAll(),findById(),save()
 * @author stella
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long>{
	/**
	 * this method is for finding an client by his name and password
	 * @param nom - name of client
	 * @param motdepasse- password of clientuser
	 * @return Client found
	 */
	Client findByNomAndMotdepasse(String nom, String motdepasse);

}
