package com.bikram.E_Wallet.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.bikram.E_Wallet.services.HelloService;
@Service
@Profile("prod")
public class RealHelloServiceImpl implements HelloService {

	@Value("${msg}")
	private String msg;
	
	@Override
	public String sayHello() {
		return "Hello From " + msg;
	}

}
