package com.bikram.E_Wallet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikram.E_Wallet.services.HelloService;
@RestController
@RequestMapping("/")
public class HelloController {

	@Autowired
	private HelloService helloService;
	
	@Value("${msg}")
	private String msg;
	
	@GetMapping("/hello")
	public String sayHello() {
		return helloService.sayHello();
	}
	
	@GetMapping("/test")
	public String test() {
		return msg;
	}
}
