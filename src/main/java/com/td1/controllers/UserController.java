package com.td1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.td1.model.entities.User;
import com.td1.model.repositories.UserRepository;
import com.td1.exception.*;



@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	@GetMapping("users")
	public List<User> getAllUsers()
	{
		return (List<User>) userRepository.findAll();
		
		
	}
	@PostMapping("users")
	public User addUser(@Valid @RequestBody User user)
	{
		
		return userRepository.save(user);
		
	}
	// Get a Single Utilisateur
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
	    return userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
	}
	  
	// Delete a Utilisateur
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

	    userRepository.delete(user);

	    return ResponseEntity.ok().build();
	}
}