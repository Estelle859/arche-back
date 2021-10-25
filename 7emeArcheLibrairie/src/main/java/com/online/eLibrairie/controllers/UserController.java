package com.online.eLibrairie.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.online.eLibrairie.repositories.UserRepository;
import com.online.eLibrairie.services.ArticleService;
import com.online.eLibrairie.services.UserService;

import ch.qos.logback.core.net.SyslogOutputStream;

import com.online.eLibrairie.models.Article;
import com.online.eLibrairie.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * UserController class is responsible for processing incoming REST API requests related to all types of users
 * @author Stella
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}	
	/**
	 * Read - Get all users
	 * @return a List object of User full filled
	 */
	 @GetMapping(path = { "", "/" })
	 public @NotNull List<User> getUsers() {
		 return userService.getAllUsers();
	 }	
	 
	/**
	 * Read - Get one user by his id
	 * @param id -the id of the user
	 * @return an user object full filled
	 */
	 @GetMapping(path = "/{id}")
	 public @NotNull User getUserById(@PathVariable Long id) {
		 
		 return userService.getUser(id);
		 
		 
	 }
	 
	 /**
	  * Create - Add a new user
	  * @param user an object User
	  * @return user object saved
	  */
	 @PostMapping(value="/add")
	 public User addUser  (@RequestBody User user) {	
	
		 return userService.save(user);
  
	  }	
	 
	/**
	 * Read - Get one user by his name and password
	 * @param nom  name of the user
	 * @param motdepasse  password of the user
	 * @return
	 */
	@GetMapping(path="/{nom}/{motdepasse}")	
	@ResponseBody
	public   @NotNull User getUserByNomAndMotdePasse(@PathVariable  String nom,@PathVariable String motdepasse)
	{
	
		return userService.getUserByNomAndMotdePasse(nom, motdepasse);			
		
	}

	

}
