package com.bikram.E_Wallet.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikram.E_Wallet.dtos.UserDto;
import com.bikram.E_Wallet.entities.User;
import com.bikram.E_Wallet.repositories.UserRepository;
import com.bikram.E_Wallet.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		User addedUser = userRepository.save(user);
		return addedUser;
	}

	@Override
	public List<User> getUsers() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@Override
	public boolean isPresent(Integer userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			return true;
		}
		return false;
	}

}
