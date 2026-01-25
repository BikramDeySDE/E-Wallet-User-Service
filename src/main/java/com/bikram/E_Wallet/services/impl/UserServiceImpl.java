package com.bikram.E_Wallet.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bikram.E_Wallet.constants.AppConstants;
import com.bikram.E_Wallet.dtos.MessageDto;
import com.bikram.E_Wallet.dtos.UserDto;
import com.bikram.E_Wallet.entities.User;
import com.bikram.E_Wallet.repositories.UserRepository;
import com.bikram.E_Wallet.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate; // for sending message to kafka
	
	@Autowired
	private ObjectMapper objectMapper; // for converting java object to json text and vice-versa

	@Override
	public User addUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		User addedUser = userRepository.save(user);
		// send message to kafka
		MessageDto messageDto = new MessageDto();
		messageDto.setUserId(addedUser.getUserId());
		messageDto.setUserName(addedUser.getUsername());
		messageDto.setUserEmail(addedUser.getUserEmail());
		messageDto.setMsg("User added successfully!!");		
		try {
			// converting java object to json text
			String jsonTextMsg = objectMapper.writeValueAsString(messageDto);
			// sending message to Kafka
			kafkaTemplate.send(AppConstants.NEW_USER, addedUser.getUsername(), jsonTextMsg); // send(topic, key, value)
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
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
