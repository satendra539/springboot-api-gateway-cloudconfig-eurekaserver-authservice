package com.sample.auth.dto;


import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@NotBlank
	private String userId;
	
	@NotBlank
	private String password;
	
    @NotBlank
	private String name;
	
}
