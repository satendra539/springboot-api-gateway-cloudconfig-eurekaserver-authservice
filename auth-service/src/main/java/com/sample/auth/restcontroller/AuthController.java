package com.sample.auth.restcontroller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.auth.dto.UserAuthRequest;
import com.sample.auth.service.IAuthService;

@RestController
@RequestMapping(value="/api/auth")
public class AuthController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAuthService authService;
	
	@Value("${jwt.header}")
	private String tokenHeader;
	
	@PostMapping(produces = "application/json")
	public String  login(@Valid @RequestBody @NotNull UserAuthRequest request) {
		logger.info("Request to authenticate for user id: , {}", request.getUserId());
	 		return authService.getAuthentication(request);
	}
	
}
