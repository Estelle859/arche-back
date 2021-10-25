package com.online.eLibrairie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.online.eLibrairie.exceptions.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.models.User;
import com.online.eLibrairie.repositories.ClientRepository;
import com.online.eLibrairie.repositories.UserRepository;
import java.util.Optional;
import java.util.List;
/**
 * This UserService Class is used to write business logic for User model to store, retrieve, update and delete the user.
 * @author stella
 *
 */
@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;

	/**
	 * constructor for an instance of UserRepository
	 * @param userRepository
	 */
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	
	}
	/**
	 * find an user by his id
	 * @param id of an user
	 * @return User found
	 */
	public Optional<User> getUserById(Long id) {return this.userRepository.findById(id);}
	
	/**
	 * find a list of all users
	 * @return list of all users
	 */
	public List<User> getAllUsers() {		
		return this.userRepository.findAll();
	}

	/**
	 * Get a User by his id if found
	 * @param id of an user
	 * @return User
	 */
    public User getUser(Long id) {
        return userRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    /**
     * retrieve an user by his username and his password
     * @param nom of the user
     * @param motdepasse of the user
     * @return User found 
     */
    public User getUserByNomAndMotdePasse(String nom, String motdepasse) {
        return 	userRepository.findByNomAndMotdepasse(nom, motdepasse);
        		
    }
    /**
     * add a new user into the user table
     * @param user
     * @return User saved
     */
    public User save(User  user) {
        return userRepository.save(user);
    }
    
    /**
     * Remove an user by his id from the table of user
     * @param id of user to be removed
     */
    public void remove(Long id) {
    	userRepository.deleteById(id);
    }
    


	
}
