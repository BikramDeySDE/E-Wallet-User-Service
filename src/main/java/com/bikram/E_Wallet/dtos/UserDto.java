package com.bikram.E_Wallet.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	@NotBlank(message = "Please enter username !!")
	private String username;
	private String password;
	private String userEmail;
	private String userAddress;
}
