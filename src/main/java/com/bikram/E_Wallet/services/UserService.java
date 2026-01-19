package com.bikram.E_Wallet.services;

import java.util.List;

import com.bikram.E_Wallet.dtos.UserDto;
import com.bikram.E_Wallet.entities.User;

public interface UserService {
	
	User addUser(UserDto userDto);
	
	List<User> getUsers();
	
	boolean isPresent(Integer userId);
	
}
