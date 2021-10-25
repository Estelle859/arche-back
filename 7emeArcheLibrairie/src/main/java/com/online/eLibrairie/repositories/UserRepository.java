package com.online.eLibrairie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.online.eLibrairie.models.User;

/**
 * Interface for generic CRUD operations on a repository for User
 * @author stella
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{
	/**
	 * this method is for finding an user by his name and password
	 * @param nom - name of user
	 * @param motdepasse- password of user
	 * @return User found
	 */
		User findByNomAndMotdepasse(String nom, String motdepasse);
	
}

