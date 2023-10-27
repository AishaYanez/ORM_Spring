package com.aisha.appGallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisha.appGallery.entity.models.User;
import com.aisha.appGallery.entity.services.UserServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/users")
	private User getUser(String email){
		return(User) userService.getUser(email);
	}
	
	@PostMapping("/users")
	private void postUser(User user) {
		userService.postUser(user);
	}
	
	@DeleteMapping("/users")
	private void deleteUser(long id){
		userService.deleteUser(id);
	}
	
	@PutMapping("/users/{id}")
	private void putUser(@PathVariable(value="id") Long id, User user) {
		userService.putPassword(id, user);
	}
}
