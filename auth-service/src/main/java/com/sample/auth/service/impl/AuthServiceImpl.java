package com.sample.auth.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sample.auth.dto.UserAuthRequest;
import com.sample.auth.security.util.JwtTokenUtil;
import com.sample.auth.service.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Resource(name = "authenticationManager")
	private AuthenticationManager authManager;

	@Override
	public String getAuthentication(UserAuthRequest request) {

		UserDetails user = userDetailsService.loadUserByUsername(request.getUserId());



		if (null == user) { throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"No user found."); }



		if (!matchPassword(request.getPassword(), user.getPassword())) { 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad credentials"); }


		String token = jwtTokenUtil.generateToken(request.getUserId(), null);

		return token;
	}

	public boolean matchPassword(CharSequence rawPassword, String encodedPassword) {
		if (encodedPassword == null || encodedPassword.length() == 0) {
			return false;
		}
		if (!passwordEncoder.matches(rawPassword.toString(), encodedPassword)) {
			return false;
		}

		return true;
	}


	

}
