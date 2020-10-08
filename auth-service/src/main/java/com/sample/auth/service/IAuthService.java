package com.sample.auth.service;

import com.sample.auth.dto.UserAuthRequest;

public interface IAuthService {

	public String getAuthentication(UserAuthRequest request);

}
