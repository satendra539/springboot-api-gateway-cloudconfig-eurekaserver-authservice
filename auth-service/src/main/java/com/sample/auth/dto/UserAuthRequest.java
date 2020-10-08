package com.sample.auth.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserAuthRequest {
	
	@NotBlank
	private String userId;
	
	@NotBlank
	private String password;

}
