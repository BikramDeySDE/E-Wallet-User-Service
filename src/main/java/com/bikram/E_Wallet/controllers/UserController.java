package com.bikram.E_Wallet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikram.E_Wallet.dtos.UserDto;
import com.bikram.E_Wallet.entities.User;
import com.bikram.E_Wallet.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody @Valid UserDto userDto) {
		User addedUser = userService.addUser(userDto);
		return new ResponseEntity<User>(addedUser, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		List<User> userList = userService.getUsers();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	@GetMapping("/verify/{userId}")
	public boolean isPresent(@PathVariable Integer userId) {
		return userService.isPresent(userId);
	}
	
}
