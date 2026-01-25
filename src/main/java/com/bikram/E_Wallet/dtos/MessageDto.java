package com.bikram.E_Wallet.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto implements Serializable {

	private Integer userId;
	private String userName;
	private String userEmail;
	private String msg;
	
}